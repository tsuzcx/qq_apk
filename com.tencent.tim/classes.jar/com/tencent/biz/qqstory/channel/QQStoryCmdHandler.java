package com.tencent.biz.qqstory.channel;

import acfp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import ppu;
import ppw;
import ppw.a;
import ppx;
import ppy;
import ppz;
import pqb;
import pqc;
import ram;
import rar;
import rpc;

public class QQStoryCmdHandler
{
  public Set<Integer> aB = new CopyOnWriteArraySet();
  private AtomicInteger ak = new AtomicInteger(100);
  public Handler be = new Handler(Looper.getMainLooper());
  private Map<Integer, ppw> fH = new ConcurrentHashMap();
  public List<a> mu = new ArrayList();
  
  public QQStoryCmdHandler()
  {
    Bosses.get().postJob(new ppx(this, "Q.qqstory.net:QQStoryCmdHandler"));
  }
  
  private void a(ppw paramppw, int paramInt, String paramString, long paramLong)
  {
    rar.b("story_net", paramppw.mg(), 0, paramInt, new String[] { paramString, String.valueOf(paramLong), rar.getNetworkType(BaseApplication.getContext()) });
  }
  
  private void a(ppw paramppw, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("start_time");
    l = System.currentTimeMillis() - l;
    int i = paramBundle.getInt("data_error_code");
    if (i != 0)
    {
      paramArrayOfByte = paramBundle.getString("data_error_msg");
      if (((i == 2901) || (i == 1002) || (i == 1003)) && (a(paramppw)))
      {
        ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramppw.mg() + " channel error:%d, msg:%s, take time:%d ,retry time:%d , retry now", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l), Integer.valueOf(paramppw.mRetryTime) });
        paramppw.mRetryTime += 1;
        paramArrayOfByte = Bosses.get();
        paramppw = new pqc(this, "Q.qqstory.net:QQStoryCmdHandler", paramppw);
        if (i == 2901) {}
        for (i = 500;; i = 2000)
        {
          paramArrayOfByte.scheduleJobDelayed(paramppw, i);
          return;
        }
      }
      paramppw.a().a(i, acfp.m(2131712215), null);
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramppw.mg() + " channel error:%d, msg:%s, take time:%d", new Object[] { Integer.valueOf(i), paramArrayOfByte, Long.valueOf(l) });
      a(paramppw, i, paramArrayOfByte, l);
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramppw.a().a(-1, "channel error null data", null);
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:" + paramppw.mg() + " channel error null data, take time:%d", new Object[] { Long.valueOf(l) });
      a(paramppw, 940002, "rsp data error", l);
      return;
    }
    paramBundle = null;
    try
    {
      ppu localppu = paramppw.a(paramArrayOfByte);
      paramBundle = localppu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ram.e("Q.qqstory.net:QQStoryCmdHandler", "decode pb fail", localException);
      }
    }
    if (paramBundle == null)
    {
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error. response is null", new Object[] { paramppw.mg() });
      a(paramppw, 940002, "response is null", l);
      return;
    }
    if (paramBundle.errorCode == 0) {
      ram.a("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s success take time:%d data length=%d respond:%s", paramppw.mg(), Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length), paramBundle);
    }
    for (;;)
    {
      paramppw.a().a(paramBundle.errorCode, paramBundle.errorMsg, paramBundle);
      a(paramppw, paramBundle.errorCode, paramBundle.errorMsg, l);
      return;
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%d msg:%s take time:%d data length%d", new Object[] { paramppw.mg(), Integer.valueOf(paramBundle.errorCode), paramBundle.errorMsg, Long.valueOf(l), Integer.valueOf(paramArrayOfByte.length) });
      if (paramBundle.errorCode == 10001) {
        ram.w("Q.qqstory.net:QQStoryCmdHandler", "get cmd:%s error:%s", new Object[] { paramppw.mg(), paramppw });
      }
    }
  }
  
  private boolean a(ppw paramppw)
  {
    return (this.aB.contains(Integer.valueOf(paramppw.sr()))) && (paramppw.mRetryTime < paramppw.bjM);
  }
  
  public void a(Bundle paramBundle, byte[] paramArrayOfByte)
  {
    Bosses.get().postJob(new pqb(this, "Q.qqstory.net:QQStoryCmdHandler", paramBundle, paramArrayOfByte));
  }
  
  public void a(ppw paramppw)
  {
    try
    {
      if (!rpc.hasInternet(QQStoryContext.a().getApplication()))
      {
        Bosses.get().scheduleJobDelayed(new ppy(this, "Q.qqstory.net:QQStoryCmdHandler", paramppw), 100);
        return;
      }
      Bosses.get().postJob(new ppz(this, "Q.qqstory.net:QQStoryCmdHandler", paramppw));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ram.e("Q.qqstory.net:QQStoryCmdHandler", "send cmd:" + paramppw.mg() + " error:" + localIllegalArgumentException.getMessage());
      paramppw.a().a(940001, localIllegalArgumentException.getMessage(), null);
    }
  }
  
  public void re(@NonNull String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        int j = paramString.getInt(i);
        this.aB.add(Integer.valueOf(j));
        i += 1;
      }
      ram.w("Q.qqstory.net:QQStoryCmdHandler", "update retry proto complete :%s", new Object[] { this.aB });
      return;
    }
    catch (Exception paramString)
    {
      ram.e("Q.qqstory.net:QQStoryCmdHandler", "update retry proto list error :%s", new Object[] { paramString.getMessage() });
    }
  }
  
  public static class IllegalUinException
    extends Exception
  {
    public IllegalUinException(String paramString)
    {
      super();
    }
  }
  
  public static class a
  {
    public final long Al;
    public final String aui;
    public int bjN;
    public final String mCmd;
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof a)) {
        return TextUtils.equals(((a)paramObject).mCmd, this.mCmd);
      }
      return false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(this.mCmd));
      localStringBuilder.append("\n");
      localStringBuilder.append("-t ");
      localStringBuilder.append(this.aui);
      localStringBuilder.append("  -dt ");
      localStringBuilder.append(String.valueOf(this.Al));
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler
 * JD-Core Version:    0.7.0.1
 */