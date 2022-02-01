package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kxm;
import mqq.os.MqqHandler;

public class ReadInJoyNickNameTextView
  extends TextView
  implements ReadInJoyUserInfoModule.a
{
  private a a;
  private boolean arZ;
  private long mUin;
  
  public ReadInJoyNickNameTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyNickNameTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(ReadInJoyUserInfo paramReadInJoyUserInfo, boolean paramBoolean)
  {
    if (paramReadInJoyUserInfo == null) {}
    for (;;)
    {
      return;
      if (this.arZ) {
        setText(kxm.ew(paramReadInJoyUserInfo.nick));
      }
      while (this.a != null)
      {
        this.a.nU(paramReadInJoyUserInfo.nick);
        return;
        setText(paramReadInJoyUserInfo.nick);
      }
    }
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyNickNameTextView", 2, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.equals(paramString, String.valueOf(this.mUin))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyNickNameTextView.1(this, paramReadInJoyUserInfo));
  }
  
  public void setNickNameByUin(long paramLong)
  {
    setNickNameByUin(paramLong, false);
  }
  
  public void setNickNameByUin(long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L) {
      return;
    }
    this.mUin = paramLong;
    this.arZ = paramBoolean;
    Object localObject = ReadInJoyUserInfoModule.a(this.mUin, this);
    String str = ReadInJoyUserInfoModule.getDefaultNickName();
    if (localObject == null)
    {
      localObject = str;
      if (this.arZ) {
        localObject = kxm.ew(str);
      }
      setText((CharSequence)localObject);
      return;
    }
    a((ReadInJoyUserInfo)localObject, this.arZ);
  }
  
  public void setNickNameByUin(String paramString)
  {
    setNickNameByUin(paramString, false);
  }
  
  public void setNickNameByUin(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyNickNameTextView", 2, "UinStr is illegal");
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyNickNameTextView", 2, paramString.getMessage());
      }
    }
    setNickNameByUin(l1, paramBoolean);
  }
  
  public void setOnSetNickNameListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void nU(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView
 * JD-Core Version:    0.7.0.1
 */