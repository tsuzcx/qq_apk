package com.tencent.biz.lebasearch;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.Serializable;
import java.util.List;
import jnl;
import jqc;
import jsj;
import jsk;
import mqq.app.NewIntent;

public class SearchProtocol
{
  public static void a(AppInterface paramAppInterface, Context paramContext, a parama)
  {
    if ((paramAppInterface == null) || (parama == null)) {
      return;
    }
    paramContext = new jsj(Looper.getMainLooper(), parama);
    if (jqc.getNetWorkType() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -1;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    parama = new NewIntent(paramAppInterface.getApp(), jnl.class);
    parama.putExtra("cmd", "PubAccountArticleCenter.GetSearchHotwords");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(1);
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRequestBody.search_request.set(localRootSearcherRequest);
    localRequestBody.version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    parama.putExtra("data", localRequestBody.toByteArray());
    parama.setObserver(new jsk(paramContext));
    paramAppInterface.startServlet(parama);
  }
  
  private static int aE(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("#")) || (paramString.length() > 9) || (paramString.length() < 6)) {
      return 0;
    }
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static class WordItem
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    public String contentDescription;
    public int frameColor;
    public String id;
    public String jumpUrl;
    public int textColor;
    public int type = 1;
    public String word;
  }
  
  public static class a
  {
    public void i(int paramInt, List<SearchProtocol.WordItem> paramList) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol
 * JD-Core Version:    0.7.0.1
 */