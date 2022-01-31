package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCallback;

/**
 * @author chaosxian
 */
interface PluginCommunicationChannel {
    /**
     * get the uin
     */
    long getUin();
    
    /**
     * get the nickname
     */
    String getNickName();
    
    /**
     * get the skey
     */
    String getSKey();
    
    /**
     * get the sid
     */
    String getSid();
    
    /**
     * transfer cmd to server process synchronously.
     */
    Bundle transfer(String cmd, in Bundle params);
    
    /**
     * transfer cmd to server process asynchronously.
     */
    void transferAsync(String cmd, in Bundle params, RemoteCallback cb);
}