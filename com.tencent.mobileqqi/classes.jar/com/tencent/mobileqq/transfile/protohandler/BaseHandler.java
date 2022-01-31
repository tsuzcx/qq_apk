package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.AppConstants.RichMediaErrorCode;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.IProtoRespBack;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class BaseHandler
  implements AppConstants.RichMediaErrorCode, ProtoReqManager.IProtoRespBack, RichProtoProc.RichProtoHandler
{
  public static final String c = "Q.richmedia.BaseHandler";
  int aj = 0;
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, MessageObserver.StatictisInfo paramStatictisInfo, RichProto.RichProtoResp.RespCommon paramRespCommon)
  {
    paramRespCommon.c = paramInt1;
    paramRespCommon.jdField_d_of_type_Int = paramInt2;
    paramRespCommon.jdField_e_of_type_JavaLangString = paramString1;
    paramRespCommon.jdField_d_of_type_JavaLangString = paramString2;
    if (paramInt1 == 0)
    {
      paramRespCommon.jdField_e_of_type_Int = 1;
      paramRespCommon.f = (paramStatictisInfo.c - 1);
    }
    do
    {
      return;
      paramRespCommon.jdField_e_of_type_Int = 0;
      paramRespCommon.f = paramStatictisInfo.c;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richmedia.BaseHandler", 2, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramStatictisInfo, (RichProto.RichProtoResp.RespCommon)paramList.next());
    }
  }
  
  abstract void a(RichProto.RichProtoReq paramRichProtoReq);
  
  void a(RichProto.RichProtoReq paramRichProtoReq, ProtoReqManager.ProtoReq paramProtoReq)
  {
    a(paramRichProtoReq);
    paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$ProtoReq = paramProtoReq;
    paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(paramProtoReq);
  }
  
  public void b(RichProto.RichProtoReq paramRichProtoReq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BaseHandler
 * JD-Core Version:    0.7.0.1
 */