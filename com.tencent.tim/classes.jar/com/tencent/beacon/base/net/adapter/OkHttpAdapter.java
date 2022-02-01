package com.tencent.beacon.base.net.adapter;

import android.support.annotation.Nullable;
import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class OkHttpAdapter
  extends AbstractNetAdapter
{
  private OkHttpClient client;
  private int failCount;
  
  private OkHttpAdapter()
  {
    this.client = new OkHttpClient.Builder().connectTimeout(30000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).build();
  }
  
  private OkHttpAdapter(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  private RequestBody buildBody(e parame)
  {
    BodyType localBodyType = parame.a();
    int i = e.a[localBodyType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return RequestBody.create(MediaType.parse("multipart/form-data"), parame.c());
      }
      return RequestBody.create(MediaType.parse(localBodyType.httpType), parame.f());
    }
    return RequestBody.create(MediaType.parse(localBodyType.httpType), com.tencent.beacon.base.net.b.d.b(parame.d()));
  }
  
  public static AbstractNetAdapter create(@Nullable OkHttpClient paramOkHttpClient)
  {
    if (paramOkHttpClient != null) {
      return new OkHttpAdapter(paramOkHttpClient);
    }
    return new OkHttpAdapter();
  }
  
  private Headers mapToHeaders(Map<String, String> paramMap)
  {
    Headers.Builder localBuilder = new Headers.Builder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getValue() != null) {
        localBuilder.add((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    return localBuilder.build();
  }
  
  public void request(JceRequestEntity paramJceRequestEntity, Callback<byte[]> paramCallback)
  {
    RequestBody localRequestBody = RequestBody.create(MediaType.parse("jce"), paramJceRequestEntity.getContent());
    Headers localHeaders = mapToHeaders(paramJceRequestEntity.getHeader());
    String str = paramJceRequestEntity.getType().name();
    paramJceRequestEntity = paramJceRequestEntity.getUrl();
    paramJceRequestEntity = new Request.Builder().url(paramJceRequestEntity).tag(str).post(localRequestBody).headers(localHeaders).build();
    this.client.newCall(paramJceRequestEntity).enqueue(new c(this, paramCallback, str));
  }
  
  public void request(e parame, Callback<BResponse> paramCallback)
  {
    String str = parame.h();
    Object localObject = buildBody(parame);
    localObject = new Request.Builder().url(parame.i()).method(parame.g().name(), (RequestBody)localObject).headers(mapToHeaders(parame.e()));
    if (str == null) {}
    for (parame = "beacon";; parame = str)
    {
      parame = ((Request.Builder)localObject).tag(parame).build();
      this.client.newCall(parame).enqueue(new d(this, paramCallback, str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.adapter.OkHttpAdapter
 * JD-Core Version:    0.7.0.1
 */