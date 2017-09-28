package com.nowcoder.async;

import java.util.List;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface EventHandler {
    void doHandler(EventModel eventModel);
    List<EventType> getSupportEventTypes();
}
