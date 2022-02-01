package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.os.Message;
import com.tencent.thumbplayer.core.common.TPDetailInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.log.TPBaseLogger;

class TPThumbPlayer$1
  implements ITPNativePlayerMessageCallback
{
  TPThumbPlayer$1(TPThumbPlayer paramTPThumbPlayer) {}
  
  private void sendMessage(int paramInt, Object paramObject)
  {
    if (TPThumbPlayer.access$100(this.this$0) != null) {
      Message.obtain(TPThumbPlayer.access$100(this.this$0), paramInt, paramObject).sendToTarget();
    }
  }
  
  public void onASyncCallResult(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    TPThumbPlayer.access$000(this.this$0).info("onASyncCallResult, callType:" + paramInt1 + ", opaque:" + paramLong + ", errorType:" + paramInt2 + ", errorCode:" + paramInt3);
    TPThumbPlayer.OnASyncCallResultInfo localOnASyncCallResultInfo = new TPThumbPlayer.OnASyncCallResultInfo();
    localOnASyncCallResultInfo.callType = paramInt1;
    localOnASyncCallResultInfo.opaque = paramLong;
    localOnASyncCallResultInfo.errorType = paramInt2;
    localOnASyncCallResultInfo.errorCode = paramInt3;
    sendMessage(1, localOnASyncCallResultInfo);
  }
  
  public void onDetailInfo(TPDetailInfo paramTPDetailInfo)
  {
    TPThumbPlayer.access$000(this.this$0).info("onDetailInfo, type:" + paramTPDetailInfo.type + ", time:" + paramTPDetailInfo.timeSince1970Us);
    sendMessage(5, paramTPDetailInfo);
  }
  
  public void onError(int paramInt1, int paramInt2)
  {
    TPThumbPlayer.access$000(this.this$0).info("onError, msgType:" + paramInt1 + ", errorCode:" + paramInt2);
    TPThumbPlayer.OnErrorInfo localOnErrorInfo = new TPThumbPlayer.OnErrorInfo();
    localOnErrorInfo.msgType = paramInt1;
    localOnErrorInfo.errorCode = paramInt2;
    sendMessage(4, localOnErrorInfo);
  }
  
  public void onInfoLong(int paramInt, long paramLong1, long paramLong2)
  {
    TPThumbPlayer.access$000(this.this$0).info("onInfoLong, infoType:" + paramInt + ", lParam1:" + paramLong1 + ", lParam2:" + paramLong2);
    TPThumbPlayer.OnInfoLongInfo localOnInfoLongInfo = new TPThumbPlayer.OnInfoLongInfo();
    localOnInfoLongInfo.infoType = paramInt;
    localOnInfoLongInfo.lParam1 = paramLong1;
    localOnInfoLongInfo.lParam2 = paramLong2;
    sendMessage(2, localOnInfoLongInfo);
  }
  
  public void onInfoObject(int paramInt, Object paramObject)
  {
    TPThumbPlayer.access$000(this.this$0).info("onInfoObject, infoType:" + paramInt + ", objParam:" + paramObject);
    TPThumbPlayer.OnInfoObjectInfo localOnInfoObjectInfo = new TPThumbPlayer.OnInfoObjectInfo();
    localOnInfoObjectInfo.infoType = paramInt;
    localOnInfoObjectInfo.objParam = paramObject;
    sendMessage(3, localOnInfoObjectInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayer.1
 * JD-Core Version:    0.7.0.1
 */