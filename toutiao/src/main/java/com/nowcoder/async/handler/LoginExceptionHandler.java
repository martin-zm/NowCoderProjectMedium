package com.nowcoder.async.handler;

import com.nowcoder.async.EventHandler;
import com.nowcoder.async.EventModel;
import com.nowcoder.async.EventType;
import com.nowcoder.model.Message;
import com.nowcoder.service.MessageService;
import com.nowcoder.util.MailSender;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.*;

/**
 * Created by nowcoder on 2016/7/14.
 */
@Component
public class LoginExceptionHandler implements EventHandler {
    @Autowired
    MessageService messageService;

    @Autowired
    MailSender mailSender;

    @Autowired
    FreeMarkerConfigurer freeMarkerConfigurer;


    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    @Override
    public void doHandler(EventModel model) {
        try{
            Message message = new Message();
            message.setToId(model.getActorId());
            message.setContent("你上次的登陆IP异常");
            // SYSTEM ACCOUNT
            message.setFromId(3);
            message.setCreatedDate(new Date());
            messageService.addMessage(message);

            Map<String, Object> map = new HashMap();
            map.put("username", model.getExts("username"));
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mails/welcome.ftl");
            mailSender.sendWithHTMLTemplate(model.getExts("to"), "登陆异常",
                    template, map);
        } catch (Exception e) {
            logger.error("登录异常" + e.getMessage());
        }
    }

    @Override
    public List<EventType> getSupportEventTypes() {
        return Arrays.asList(EventType.LOGIN);
    }
}
