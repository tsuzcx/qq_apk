package com.tencent.mobileqq.pluginsdk.ipc;

import android.os.Bundle;

/**
 * @author chaosxian
 */
interface RemoteCallback {
	void onRemoteCallback(in Bundle b);
}