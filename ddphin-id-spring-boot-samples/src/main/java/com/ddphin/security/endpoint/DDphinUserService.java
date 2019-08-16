package com.ddphin.security.endpoint;

import com.ddphin.id.endpoint.IDWorkerAware;
import org.springframework.stereotype.Service;

/**
 * DDphinUserService
 *
 * @Date 2019/8/16 上午11:13
 * @Author ddphin
 */
@Service
public class DDphinUserService extends IDWorkerAware {

    public long nextUserId() {
        return this.nextId();
    }
}
