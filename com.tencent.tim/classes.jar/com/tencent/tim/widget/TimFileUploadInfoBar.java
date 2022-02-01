package com.tencent.tim.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import atgi;
import auqo;
import auqp;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.triton.sdk.utils.ThreadUtil;
import com.tencent.mobileqq.widget.RotateableView;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

@RequiresApi(api=19)
public class TimFileUploadInfoBar
  extends FrameLayout
{
  private View Le;
  private TextView afG;
  private TextView afH;
  private CloudFileCallbackCenter b = new a(this);
  private RotateableView c;
  private Map<Long, Integer> de = new ArrayMap();
  private Context mContext;
  
  public TimFileUploadInfoBar(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimFileUploadInfoBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimFileUploadInfoBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initView(paramContext);
    post(new TimFileUploadInfoBar.1(this));
  }
  
  private void HD()
  {
    this.de.clear();
    atgi.a().e(new auqp(this));
  }
  
  private static boolean a(CloudUploadFile paramCloudUploadFile)
  {
    if (paramCloudUploadFile == null) {}
    while ((paramCloudUploadFile.uploadType != 0) || (!TextUtils.isEmpty(paramCloudUploadFile.teamId))) {
      return true;
    }
    return false;
  }
  
  private void ewk()
  {
    animate().cancel();
    animate().setDuration(200L).setStartDelay(3000L).alpha(0.0F).withEndAction(new TimFileUploadInfoBar.3(this)).start();
  }
  
  private void ewl()
  {
    Iterator localIterator = this.de.values().iterator();
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    if (localIterator.hasNext())
    {
      int i1;
      switch (((Integer)localIterator.next()).intValue())
      {
      case 2: 
      default: 
        n = m;
        i1 = k;
        m = i;
        k = j;
        j = i1;
        i = n;
      }
      for (;;)
      {
        n = m;
        i1 = k;
        m = i;
        k = j;
        j = i1;
        i = n;
        break;
        n = j;
        i1 = i + 1;
        i = m;
        j = k;
        k = n;
        m = i1;
        continue;
        i1 = m + 1;
        m = j;
        n = i;
        i = i1;
        j = k;
        k = m;
        m = n;
        continue;
        i1 = k + 1;
        k = j;
        n = i;
        i = m;
        j = i1;
        m = n;
        continue;
        i1 = j + 1;
        n = i;
        i = m;
        j = k;
        k = i1;
        m = n;
      }
    }
    int n = m + k + j + i;
    QLog.d("TimFileUploadInfoBar", 4, "total:" + n + " uploading:" + m + " wait:" + k + " fail:" + i + " succ:" + j);
    if ((k == 0) && (i != 0))
    {
      show();
      aaX(i);
      return;
    }
    if ((k == 0) && (m == 0))
    {
      this.de.clear();
      bmn();
      return;
    }
    if (m == 0)
    {
      show();
      J(j, n, true);
      return;
    }
    show();
    J(j, n, false);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131563189, this, false);
    this.c = ((RotateableView)paramContext.findViewById(2131377620));
    this.Le = paramContext.findViewById(2131369735);
    this.afG = ((TextView)paramContext.findViewById(2131381012));
    this.afH = ((TextView)paramContext.findViewById(2131381013));
    paramContext.setOnClickListener(new auqo(this));
    this.c.setBackgroundResource(2130840768);
    addView(paramContext);
    setVisibility(8);
  }
  
  private void lg(List<FileManagerEntity> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CloudUploadFile localCloudUploadFile = ((FileManagerEntity)paramList.next()).uploadFile;
      if (!a(localCloudUploadFile)) {
        this.de.put(Long.valueOf(localCloudUploadFile.taskId), Integer.valueOf(localCloudUploadFile.uploadStatus));
      }
    }
    updateUI();
  }
  
  private void updateUI()
  {
    if (ThreadUtil.isMainThread())
    {
      ewl();
      return;
    }
    post(new TimFileUploadInfoBar.5(this));
  }
  
  public void J(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    TextView localTextView;
    Context localContext;
    if (paramBoolean)
    {
      this.c.eiN();
      this.Le.setVisibility(8);
      this.afH.setVisibility(8);
      localTextView = this.afG;
      localContext = this.mContext;
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (int i = 2131690827;; i = 2131690826)
    {
      localTextView.setText(localContext.getString(i, new Object[] { String.valueOf(paramInt1), String.valueOf(paramInt2) }));
      return;
      this.c.eiM();
      break;
    }
  }
  
  public void aaX(int paramInt)
  {
    this.c.eiN();
    this.Le.setVisibility(0);
    this.afH.setVisibility(0);
    this.afG.setText(this.mContext.getString(2131690823, new Object[] { String.valueOf(paramInt) }));
  }
  
  public void bmn()
  {
    this.c.eiN();
    this.Le.setVisibility(8);
    this.afH.setVisibility(8);
    this.afG.setText(2131690825);
    ewk();
  }
  
  public void initData()
  {
    HD();
    atgi.a().a(this.b);
  }
  
  public void show()
  {
    setVisibility(0);
    setAlpha(1.0F);
  }
  
  static class a
    extends CloudFileCallbackCenter
  {
    private WeakReference<TimFileUploadInfoBar> bo;
    
    a(TimFileUploadInfoBar paramTimFileUploadInfoBar)
    {
      this.bo = new WeakReference(paramTimFileUploadInfoBar);
    }
    
    public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      if (this.bo.get() == null) {
        return;
      }
      QLog.d("TimFileUploadInfoBar", 4, "onDeleteUpload");
      TimFileUploadInfoBar.a((TimFileUploadInfoBar)this.bo.get()).remove(Long.valueOf(paramLong));
      TimFileUploadInfoBar.b((TimFileUploadInfoBar)this.bo.get());
    }
    
    public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
    {
      if (this.bo.get() == null) {}
      while (TimFileUploadInfoBar.b(paramCloudUploadFile)) {
        return;
      }
      QLog.d("TimFileUploadInfoBar", 4, "onStartUpload " + paramLong + " " + paramCloudUploadFile.fileInfo.showName);
      TimFileUploadInfoBar.a((TimFileUploadInfoBar)this.bo.get()).put(Long.valueOf(paramLong), Integer.valueOf(paramCloudUploadFile.uploadStatus));
      TimFileUploadInfoBar.b((TimFileUploadInfoBar)this.bo.get());
    }
    
    public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
    {
      if (this.bo.get() == null) {}
      do
      {
        return;
        QLog.d("TimFileUploadInfoBar", 4, "onStopUpload");
        paramArrayOfByte = TimFileUploadInfoBar.a((TimFileUploadInfoBar)this.bo.get());
      } while (!paramArrayOfByte.containsKey(Long.valueOf(paramLong)));
      paramArrayOfByte.put(Long.valueOf(paramLong), Integer.valueOf(3));
      TimFileUploadInfoBar.b((TimFileUploadInfoBar)this.bo.get());
    }
    
    public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
    {
      if (this.bo.get() == null) {}
      do
      {
        do
        {
          return;
        } while (TimFileUploadInfoBar.b(paramCloudUploadFile));
        QLog.d("TimFileUploadInfoBar", 4, "onUploadComplete " + paramLong);
        paramArrayOfByte = TimFileUploadInfoBar.a((TimFileUploadInfoBar)this.bo.get());
      } while (!paramArrayOfByte.containsKey(Long.valueOf(paramLong)));
      paramArrayOfByte.put(Long.valueOf(paramLong), Integer.valueOf(paramCloudUploadFile.uploadStatus));
      TimFileUploadInfoBar.b((TimFileUploadInfoBar)this.bo.get());
    }
    
    public void onUploadProgress(byte[] paramArrayOfByte, long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4)
    {
      if (this.bo.get() == null) {}
      do
      {
        return;
        QLog.d("TimFileUploadInfoBar", 4, "onUploadProgress " + paramLong1 + " progress " + paramLong3 + " progressMax " + paramLong4);
        paramArrayOfByte = TimFileUploadInfoBar.a((TimFileUploadInfoBar)this.bo.get());
      } while (!paramArrayOfByte.containsKey(Long.valueOf(paramLong1)));
      paramArrayOfByte.put(Long.valueOf(paramLong1), Integer.valueOf(1));
      TimFileUploadInfoBar.b((TimFileUploadInfoBar)this.bo.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.widget.TimFileUploadInfoBar
 * JD-Core Version:    0.7.0.1
 */