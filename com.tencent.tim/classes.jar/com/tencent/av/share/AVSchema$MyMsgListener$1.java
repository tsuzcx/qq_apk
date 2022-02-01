package com.tencent.av.share;

import acfp;
import android.text.TextUtils;
import com.tencent.av.ReqGroupVideo.RspShareBackflowVerify;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import ijl;
import jjk.b;

class AVSchema$MyMsgListener$1
  implements Runnable
{
  AVSchema$MyMsgListener$1(AVSchema.b paramb, ReqGroupVideo.RspShareBackflowVerify paramRspShareBackflowVerify, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.isDetached()) {}
    String str2;
    int i;
    do
    {
      int j;
      String str1;
      boolean bool;
      do
      {
        return;
        j = ijl.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        localObject = ijl.a(this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.result);
        str2 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_group_code.get() + "";
        long l = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint64_room_id.get();
        int k = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.uint32_room_create_time.get();
        i = 99;
        if (this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.has()) {
          i = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.enum_verify_status.get();
        }
        str1 = this.jdField_a_of_type_ComTencentAvReqGroupVideo$RspShareBackflowVerify.bytes_wording.get().toStringUtf8();
        bool = AVSchema.a(this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.a, this.jdField_a_of_type_ComTencentAvShareAVSchema$b.b);
        QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.TAG, 1, "onReceiveResult.callback, result[" + j + "], errMsg[" + (String)localObject + "], enum_verify_status[" + i + "], group_uin[" + str2 + "], uint64_room_id[" + l + "], uint32_room_create_time[" + k + "], bytes_wording[" + str1 + "], isSameInfo[" + bool + "], Activity[" + this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.getActivity() + "], isResume[" + this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.isResumed() + "], seq[" + this.kQ + "]");
      } while (!bool);
      this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.jb(false);
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        if (j == 0)
        {
          localObject = str1;
          if (i != 0)
          {
            localObject = str1;
            if (j != 0) {}
          }
        }
        else
        {
          localObject = acfp.m(2131703015);
        }
      }
      this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.a.atR = i;
      switch (i)
      {
      default: 
        this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.s(this.kQ, (String)localObject);
      }
    } while (!AudioHelper.isDev());
    Object localObject = acfp.m(2131703012) + i + "], bytes_wording[" + (String)localObject + "], seq[" + this.kQ + "]";
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.TAG, 1, (String)localObject);
    throw new RuntimeException((String)localObject);
    jjk.b.nH(0);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.jH(str2);
    return;
    jjk.b.nH(5);
    jjk.b.nH(0);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.jH(str2);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.g(this.kQ, (String)localObject, str2);
    return;
    jjk.b.nH(4);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.h(this.kQ, (String)localObject, str2);
    return;
    jjk.b.nH(i);
    this.jdField_a_of_type_ComTencentAvShareAVSchema$b.this$0.s(this.kQ, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyMsgListener.1
 * JD-Core Version:    0.7.0.1
 */