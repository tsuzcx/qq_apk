package com.tencent.qqmail.utilities.aidl;
import com.tencent.qqmail.utilities.qmnetwork.service.ReceivePacket;
import com.tencent.qqmail.utilities.qmnetwork.service.PushUser;
/**
 * 主进程中的接收service
 * @author jackie he
 **/
interface INotifyService{

	int receivePushMail(in ReceivePacket packet);
	/**
	 * 获得当前的uin
	 **/
	//PushUser getLoginUser();

	//void sync();
	
	//void syncAC(int accountid);
	
	//void startService();
	void stopService();

}