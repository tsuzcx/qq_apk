package com.tencent.qqmail.utilities.aidl;
import com.tencent.qqmail.utilities.qmnetwork.service.SendPacket;
/**
 * push进程的service接口
 * @author jackie he
 **/
interface IPushService{

	//发送一般请求
	//void sendServiceRequest(in SendPacket packet);
	//重连
	//void reStart();
	//同步新邮件数
	//void synNewMailCount(int mailCount);
	//临时使用，杀掉自己
	//void kill();
	
	//void setUMAInfo(long vid, String sessionKeyHex);
	//void setUserSetting(boolean viberate, boolean sound, boolean nightMode);
	//void setLocalSyncAccount(int pollingInterval);
	//void syncMail(in byte[] mailData);
	//void sendHeartBeat_V2();
}