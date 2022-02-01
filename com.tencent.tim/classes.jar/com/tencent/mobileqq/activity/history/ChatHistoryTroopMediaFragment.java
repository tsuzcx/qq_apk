package com.tencent.mobileqq.activity.history;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anot;
import apsd;
import apsd.b;
import apsd.c;
import aqju;
import aqlr;
import ausj;
import auss;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import xtm;
import xtp;
import xuf;
import zhe;
import zhf;

public class ChatHistoryTroopMediaFragment
  extends ChatHistoryMediaBaseFragment
{
  private apsd.c b;
  
  void b(ArrayList<xuf> paramArrayList, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToGroupAlbum()");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject = (xuf)paramArrayList.next();
      if (AIOImageData.class.isInstance(((xuf)localObject).e))
      {
        localObject = (AIOImageData)((xuf)localObject).e;
        localArrayList1.add(((AIOImageData)localObject).aVW);
        localArrayList2.add(((AIOImageData)localObject).uuid);
        localArrayList3.add(Long.valueOf(((AIOImageData)localObject).timestamp));
      }
    }
    xtm.a(getActivity(), aqlr.getUin(), getUin(), getUin(), localArrayList1, localArrayList2, localArrayList3, 2, paramString1, paramString2);
  }
  
  protected void bBS()
  {
    int k = 0;
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131690170);
    localausj.addButton(2131690171, 5);
    int m = ww();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.rA.size())
      {
        if (((((xuf)this.rA.get(i)).e instanceof AIOImageData)) && (((AIOImageData)((xuf)this.rA.get(i)).e).uuid == null)) {
          j = 1;
        }
      }
      else
      {
        if ((m == 1) && (j == 0)) {
          localausj.addButton(2131694765);
        }
        if ((m == 1) && (j == 0)) {
          localausj.addButton(2131694753, 5);
        }
        localausj.addCancelButton(2131721058);
        localausj.a(new zhe(this, localausj, (ArrayList)this.rA.clone()));
        localausj.show();
        return;
      }
      i += 1;
    }
  }
  
  void cpg()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0BE", "0X800A0BE", 1, 0, "", "", "", "");
  }
  
  void cpi()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0BC", "0X800A0BC", 1, 0, "", "", "", "");
  }
  
  void cpj()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0BA", "0X800A0BA", 1, 0, "", "", "", "");
  }
  
  protected void cpl()
  {
    bBS();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0BB", "0X800A0BB", 1, 0, "", "", "", "");
  }
  
  void cpm()
  {
    anot.a(this.mApp, "dc00898", "", "", "0X800A0BD", "0X800A0BD", 1, 0, "", "", "", "");
  }
  
  public void dj(ArrayList<xuf> paramArrayList)
  {
    Object localObject = aqlr.getUin();
    String str1 = getUin();
    if (LocalMultiProcConfig.getInt4Uin((String)localObject + "__qzone_pic_permission__" + str1, -1, Long.valueOf((String)localObject).longValue()) == 0)
    {
      paramArrayList = new aqju(getActivity(), 2131756467);
      paramArrayList.setContentView(2131559151);
      paramArrayList.setTitle(getActivity().getString(2131699885));
      paramArrayList.setMessage(getActivity().getString(2131699883));
      paramArrayList.setNegativeButton(getActivity().getString(2131699884), new zhf(this));
      paramArrayList.setCanceledOnTouchOutside(false);
      paramArrayList.setCancelable(false);
      paramArrayList.show();
      QZoneClickReport.startReportImediately((String)localObject, "40", "1");
      return;
    }
    if (paramArrayList.size() > 20)
    {
      QQToast.a(getActivity(), 2131694002, 0).show();
      return;
    }
    str1 = getActivity().getIntent().getStringExtra("UploadPhoto.key_album_id");
    String str2 = getActivity().getIntent().getStringExtra("UploadPhoto.key_album_name");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("forwardToGroupAlbum, albumId = ");
      if (str1 == null) {
        break label268;
      }
      localObject = str1;
      localStringBuilder = localStringBuilder.append((String)localObject).append(" , albumName = ");
      if (str2 == null) {
        break label275;
      }
    }
    label268:
    label275:
    for (localObject = str2;; localObject = "null")
    {
      QLog.d("ChatHistoryMediaBaseFragment", 2, (String)localObject);
      b(paramArrayList, str1, str2);
      return;
      localObject = "null";
      break;
    }
  }
  
  public void dk(ArrayList<xuf> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryMediaBaseFragment", 2, "forwardToQZoneAlbum()");
    }
    xtm.a(getActivity(), aqlr.getUin(), getUin(), 0, (List)paramArrayList.clone(), true, getUin());
  }
  
  void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      xtp.v(this.mActivity, paramIntent);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    anot.a(this.mApp, "dc00898", "", "", "0X800A0B9", "0X800A0B9", 2, 0, "", "", "", "");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null)
    {
      apsd.b(this.mApp, this.b);
      this.b = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.b != null)
    {
      apsd.b(this.mApp, this.b);
      this.b = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.b == null)
    {
      Object localObject = getUin();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new b(Long.parseLong((String)localObject));
        this.b = new a(this.mActivity, (apsd.b)localObject, this.mApp);
      }
    }
    if (this.b != null) {
      apsd.a(this.mApp, this.b);
    }
  }
  
  class a
    extends apsd.c
  {
    public a(Context paramContext, apsd.b paramb, QQAppInterface paramQQAppInterface)
    {
      super(paramb, paramQQAppInterface);
    }
    
    public void aK(Object paramObject)
    {
      super.aK(paramObject);
      if (ChatHistoryTroopMediaFragment.this.uiHandler != null) {
        ChatHistoryTroopMediaFragment.this.uiHandler.sendEmptyMessage(102);
      }
    }
  }
  
  class b
    implements apsd.b
  {
    private long Lb;
    
    public b(long paramLong)
    {
      this.Lb = paramLong;
    }
    
    public long er()
    {
      return this.Lb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment
 * JD-Core Version:    0.7.0.1
 */