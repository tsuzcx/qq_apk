package com.tencent.biz.richframework.network;

import android.content.Context;
import com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Servlet;
import oum;
import rxc;
import rxc.a;
import rxh;
import ryz;

public class VSNetworkHelper
{
  private static final VSNetworkHelper jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper = new VSNetworkHelper();
  private static final rxc jdField_a_of_type_Rxc = new rxc();
  private static volatile String aDd;
  
  private static boolean Md()
  {
    return (aDd != null) && (!aDd.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
  }
  
  public static VSNetworkHelper a()
  {
    if (aDd == null) {}
    for (;;)
    {
      try
      {
        if (aDd == null) {
          init();
        }
        return jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper;
      }
      finally {}
      if (!Md()) {
        continue;
      }
      try
      {
        if (Md())
        {
          jdField_a_of_type_ComTencentBizRichframeworkNetworkVSNetworkHelper.release();
          init();
        }
      }
      finally {}
    }
  }
  
  public static rxc a()
  {
    return jdField_a_of_type_Rxc;
  }
  
  public static boolean fQ(String paramString)
  {
    if (paramString != null) {
      return paramString.startsWith("_VSNetworkHelperCache");
    }
    return false;
  }
  
  private static void init()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: registerObserver");
    aDd = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    BaseApplicationImpl.getApplication().getRuntime().registObserver(a());
    QCircleGlobalBroadcastHelper.a().init();
  }
  
  public int a(int paramInt, VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    if (paramVSBaseRequest == null) {
      return 0;
    }
    paramVSBaseRequest.setContextHashCode(paramInt);
    a().b(paramVSBaseRequest, parama);
    parama = new RequestIntent(BaseApplicationImpl.getApplication(), rxh.class);
    parama.putExtra("key_request_data", paramVSBaseRequest);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(parama);
    QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: sendRequest: success, contextHashCode:%s, seq:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramVSBaseRequest.getCurrentSeq()) }));
    return paramVSBaseRequest.getCurrentSeq();
  }
  
  public void a(Context paramContext, VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    a(localObject.hashCode(), paramVSBaseRequest, parama);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    a(null, paramVSBaseRequest, parama);
  }
  
  public void cK(Context paramContext)
  {
    if (paramContext != null)
    {
      QLog.i("VSNetworkHelper", 2, String.format("VSNetworkHelper: cancelRequest：success, contextHashCode:%s", new Object[] { Integer.valueOf(paramContext.hashCode()) }));
      a().cL(paramContext);
    }
  }
  
  public void release()
  {
    QLog.i("VSNetworkHelper", 2, "VSNetworkHelper: release");
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(a());
    a().release();
    ryz.bhI();
    oum.bhI();
    QCircleGlobalBroadcastHelper.a().release();
    aDd = null;
  }
  
  public class RequestIntent
    extends NewIntent
  {
    public RequestIntent(Class<? extends Servlet> paramClass)
    {
      super(localClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper
 * JD-Core Version:    0.7.0.1
 */