package com.tencent.tim.filemanager.widget;

import acbn;
import acde;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.TextView;
import atgc;
import athu;
import atiz;
import atjx;
import atso;
import atwb;
import audx;
import aueh;
import auei;
import aues;
import auet;
import aueu;
import auew;
import auex;
import auey;
import auez;
import augx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.teamwork.PadInfo;
import java.lang.ref.WeakReference;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import szw;
import szy;

public class CloudSendBottomBar
  extends SendBottomBar
  implements augx
{
  private ArrayList<FileInfo> Ei;
  private TextView SB;
  private atjx a;
  public Boolean aW = Boolean.valueOf(true);
  private WeakReference<BaseActivity> activityWeakReference;
  private String aed;
  private TextView afo;
  private TextView afp;
  protected boolean ajo;
  private QQAppInterface app;
  private long ayJ;
  private long ayK;
  private boolean cgq;
  int ern;
  public int ero;
  private View.OnClickListener gA = new auex(this);
  private View.OnClickListener gB = new auey(this);
  private View.OnClickListener gC = new auez(this);
  private View.OnClickListener gw = new aues(this);
  private View.OnClickListener gx = new auet(this);
  private View.OnClickListener gy = new aueu(this);
  private View.OnClickListener gz = new auew(this);
  private BaseActivity h;
  private WeakReference<CloudSendBottomBar> iW;
  private FileInfo j = new FileInfo();
  
  public CloudSendBottomBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public CloudSendBottomBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void t(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt != 5) || (paramString2.equals(acbn.bkw)))
    {
      paramString1 = atwb.ep();
      ((acde)paramQQAppInterface.getBusinessHandler(8)).dA(paramString1);
      return;
    }
    if (paramInt == 6002)
    {
      paramString1 = atwb.ep();
      ((RouterHandler)paramQQAppInterface.getBusinessHandler(48)).a(paramString1, null, null, Long.parseLong(paramString2));
      return;
    }
    if (paramInt == 9501)
    {
      ((szy)paramQQAppInterface.getBusinessHandler(49)).a().b(paramString2, atwb.ep());
      return;
    }
    paramQQAppInterface.a().ae(paramString1, paramString2, paramInt);
  }
  
  public boolean Pp()
  {
    return this.ajo;
  }
  
  public void VJ(boolean paramBoolean) {}
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
    btB();
  }
  
  public void dmE()
  {
    am(2131696937);
    new Handler().postDelayed(new CloudSendBottomBar.8(this), 100L);
  }
  
  public void dmH()
  {
    long l1;
    long l2;
    String str;
    if ((this.ero == 4) || (this.ero == 6))
    {
      this.ayJ = (atiz.Ou() + atwb.fN());
      l1 = atiz.fP();
      l2 = atwb.fP();
      str = this.h.getString(2131691656);
      if (this.ero == 6) {
        str = this.h.getString(2131719431);
      }
      if (this.ayJ == 0L)
      {
        this.SB.setText(str);
        this.SB.setEnabled(false);
        if (this.ayJ != 0L) {
          break label215;
        }
        this.afo.setVisibility(4);
      }
    }
    label215:
    do
    {
      return;
      if (this.ayJ <= 99L)
      {
        this.SB.setEnabled(true);
        this.SB.setText(str + "(" + this.ayJ + ")");
        break;
      }
      this.SB.setEnabled(true);
      this.SB.setText(str + "(99+)");
      break;
      this.afo.setVisibility(0);
      str = this.context.getString(2131693579) + this.ayJ + "个文件，共" + aueh.g(l2 + l1);
      this.afo.setText(str);
      return;
      if ((this.h instanceof BaseFileAssistantActivity))
      {
        this.ayJ = atwb.fN();
        if (this.ayJ == 0L)
        {
          this.SB.setText(this.h.getString(2131691588));
          this.SB.setEnabled(false);
          return;
        }
        if (this.ayJ <= 99L)
        {
          this.SB.setEnabled(true);
          this.SB.setText(MessageFormat.format(this.h.getString(2131691590), new Object[] { Long.valueOf(this.ayJ) }));
          return;
        }
        this.SB.setEnabled(true);
        this.SB.setText(MessageFormat.format(this.h.getString(2131691590), new Object[] { "99+" }));
        return;
      }
    } while (this.ero != 7);
    if (atiz.Ou() + atwb.fN() == 0L)
    {
      this.SB.setText(this.h.getString(2131691588));
      this.SB.setEnabled(false);
      return;
    }
    this.SB.setText(this.h.getString(2131691588));
    this.SB.setEnabled(true);
  }
  
  public void doOnPause()
  {
    this.ajo = false;
  }
  
  public void doOnResume()
  {
    this.ajo = true;
  }
  
  public void euL() {}
  
  protected void ge(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131558977, this, true);
    this.context = paramContext;
  }
  
  protected void initUI()
  {
    this.h = ((BaseActivity)this.context);
    this.app = ((QQAppInterface)this.h.getAppRuntime());
    this.SB = ((TextView)findViewById(2131377979));
    this.afo = ((TextView)findViewById(2131380648));
    this.afp = ((TextView)findViewById(2131380649));
    this.afp.setVisibility(8);
    this.a = new atjx(this.app, this.h, this);
    this.activityWeakReference = new WeakReference(this.h);
    this.iW = new WeakReference(this);
    long l1 = atiz.Ou();
    long l2 = atwb.fN();
    TextView localTextView = this.afo;
    if (l1 + l2 == 0L) {}
    for (int i = 4;; i = 0)
    {
      localTextView.setVisibility(i);
      if ((this.context instanceof BaseFileAssistantActivity)) {
        this.aed = ((BaseFileAssistantActivity)this.context).uW();
      }
      return;
    }
  }
  
  public Boolean m()
  {
    return this.aW;
  }
  
  public void setClickListener(auei paramauei) {}
  
  public void setDestinationFileInfo(FileInfo paramFileInfo)
  {
    if (paramFileInfo == null) {}
    do
    {
      return;
      if (!this.SB.isEnabled()) {
        this.SB.setEnabled(true);
      }
      this.j = paramFileInfo;
    } while ((this.ern != 0) || (paramFileInfo.getName() == null) || (paramFileInfo.getName().equals(this.h.getString(2131691602))) || (this.afo.getVisibility() != 0));
    this.afo.setText(paramFileInfo.getName());
  }
  
  public void setEditBtnVisible(boolean paramBoolean) {}
  
  public void setFilesToBeDealtWith(ArrayList<FileInfo> paramArrayList)
  {
    this.Ei = paramArrayList;
  }
  
  public void setLeftAction(int paramInt)
  {
    this.ern = paramInt;
    Object localObject = (atgc)this.app.getManager(373);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.afp.setVisibility(8);
      this.afo.setText(2131691645);
      this.afo.setOnClickListener(this.gB);
      this.afo.setVisibility(0);
      return;
    case 0: 
      this.afp.setVisibility(0);
      if ((this.j.Y() == null) || (Arrays.equals(this.j.Y(), ((atgc)localObject).aE())) || (Arrays.equals(this.j.Y(), ((atgc)localObject).aG())))
      {
        this.j.bf(((atgc)localObject).aE());
        localObject = ((atgc)localObject).EO();
        this.j.setName((String)localObject);
        this.afo.setText(2131691589);
      }
      for (;;)
      {
        this.afo.setOnClickListener(this.gC);
        this.afo.setVisibility(0);
        return;
        if (this.j.getName() != null) {
          this.afo.setText(this.j.getName());
        }
      }
    }
    this.afp.setVisibility(8);
    this.ayJ = (atiz.Ou() + atwb.fN());
    this.ayK = (atiz.fP() + atwb.fP());
    localObject = this.context.getString(2131693579) + this.ayJ + "个文件，共" + aueh.g(this.ayK);
    this.afo.setText((CharSequence)localObject);
  }
  
  public void setRightAction(int paramInt)
  {
    this.ero = paramInt;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 1: 
    case 3: 
    case 5: 
      atgc localatgc = (atgc)this.app.getManager(373);
      this.SB.setText(2131691970);
      if (this.j.Y() == null) {
        this.SB.setEnabled(false);
      }
      for (;;)
      {
        this.SB.setOnClickListener(this.gw);
        return;
        if (this.Ei != null)
        {
          Iterator localIterator = this.Ei.iterator();
          while (localIterator.hasNext())
          {
            FileInfo localFileInfo = (FileInfo)localIterator.next();
            if (Arrays.equals(localFileInfo.X(), this.j.Y())) {
              this.SB.setEnabled(false);
            }
            if ((!localFileInfo.isDirectory()) && (Arrays.equals(this.j.Y(), localatgc.aE()))) {
              this.SB.setEnabled(false);
            }
          }
        }
        if ((!m().booleanValue()) && (Arrays.equals(this.j.Y(), localatgc.aE()))) {
          this.SB.setEnabled(false);
        }
      }
    case 0: 
      this.SB.setText(2131691588);
      this.SB.setEnabled(false);
      this.SB.setOnClickListener(this.gx);
      return;
    case 4: 
      this.SB.setText(2131691656);
      if (atiz.Ou() == 0) {
        this.SB.setEnabled(false);
      }
      for (;;)
      {
        this.SB.setOnClickListener(this.gy);
        return;
        this.SB.setEnabled(true);
      }
    case 6: 
      this.SB.setText(2131719431);
      if (atiz.Ou() == 0) {
        this.SB.setEnabled(false);
      }
      for (;;)
      {
        this.SB.setOnClickListener(this.gz);
        return;
        this.SB.setEnabled(true);
      }
    }
    this.SB.setText(2131719431);
    if (atiz.Ou() == 0) {
      this.SB.setEnabled(false);
    }
    for (;;)
    {
      this.SB.setOnClickListener(this.gA);
      return;
      this.SB.setEnabled(true);
    }
  }
  
  public void setRootDirSelectable(Boolean paramBoolean)
  {
    this.aW = paramBoolean;
  }
  
  public static class a
    extends AsyncTask<Void, Void, Void>
  {
    WeakReference<BaseActivity> activityWeakReference;
    WeakReference<CloudSendBottomBar> iW;
    String senderUin;
    
    public a(WeakReference<BaseActivity> paramWeakReference, WeakReference<CloudSendBottomBar> paramWeakReference1, String paramString)
    {
      this.activityWeakReference = paramWeakReference;
      this.iW = paramWeakReference1;
      this.senderUin = paramString;
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      paramVarArgs = atiz.ER();
      int j = atiz.Ov();
      String str = atiz.ES();
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramVarArgs != null)
      {
        int i = 0;
        Object localObject;
        while (i < atiz.el().size())
        {
          localObject = (FileManagerEntity)atiz.el().get(i);
          if (this.activityWeakReference.get() != null) {
            localQQAppInterface.a().d(audx.c((FileManagerEntity)localObject), str, paramVarArgs, j, 0);
          }
          int k = ((FileManagerEntity)localObject).nFileType;
          i += 1;
        }
        i = 0;
        while (i < atiz.ek().size())
        {
          localObject = (PadInfo)atiz.ek().get(i);
          if (this.activityWeakReference.get() != null) {
            localQQAppInterface.a().a(((PadInfo)localObject).pad_url, ((PadInfo)localObject).title, ((PadInfo)localObject).type, j, paramVarArgs, (Activity)this.activityWeakReference.get());
          }
          i += 1;
        }
        i = 0;
        while (i < atiz.en().size())
        {
          localObject = athu.a((FileManagerEntity)atiz.en().get(i));
          if (this.activityWeakReference.get() != null) {
            localQQAppInterface.a().a(((PadInfo)localObject).pad_url, ((PadInfo)localObject).title, ((PadInfo)localObject).type, j, paramVarArgs, (Activity)this.activityWeakReference.get());
          }
          i += 1;
        }
        if (atwb.fN() > 0L) {
          CloudSendBottomBar.u(localQQAppInterface, str, paramVarArgs, j);
        }
        localQQAppInterface.a().eux();
      }
      return null;
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      super.onPostExecute(paramVoid);
      if (this.iW.get() != null) {
        ((CloudSendBottomBar)this.iW.get()).btB();
      }
      if (this.activityWeakReference.get() != null)
      {
        ((BaseActivity)this.activityWeakReference.get()).setResult(-1);
        ((BaseActivity)this.activityWeakReference.get()).finish();
      }
      atiz.clearSelected();
      atwb.clearSelected();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.CloudSendBottomBar
 * JD-Core Version:    0.7.0.1
 */