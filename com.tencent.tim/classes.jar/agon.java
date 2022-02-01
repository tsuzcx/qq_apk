import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agon
  extends agog
{
  private List<FileManagerEntity> Bw = new ArrayList();
  private CharSequence U;
  private String bIE;
  private CharSequence mDescription;
  
  public agon(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public int Ey()
  {
    return this.Bw.size();
  }
  
  public List<ampx> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.Bw.iterator();
    while (paramContext.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramContext.next();
      agon localagon = new agon(this.wB, this.mFromType);
      localagon.cA(this.aZ);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileManagerEntity);
      localagon.kI(localArrayList);
      paramQQAppInterface.add(localagon);
    }
    return paramQQAppInterface;
  }
  
  public boolean alP()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    if (localFileManagerEntity != null) {
      return agmz.b(localFileManagerEntity);
    }
    return false;
  }
  
  public void cA(Bundle paramBundle)
  {
    super.cA(paramBundle);
    if (this.aZ != null) {
      this.bIE = this.aZ.getString("qfile_search_param_ex_params_target_uin", "");
    }
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    int i = 7;
    if (this.U != null) {
      return this.U;
    }
    int j = this.Bw.size();
    Object localObject1;
    if (j > 1)
    {
      localObject1 = new SpannableStringBuilder(j + acfp.m(2131706230) + "\"");
      ((SpannableStringBuilder)localObject1).append(amxk.a(this.wB, this.wB));
      ((SpannableStringBuilder)localObject1).append("\"").append(acfp.m(2131693575));
      this.U = ((CharSequence)localObject1);
      return this.U;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = ahav.e((FileManagerEntity)this.Bw.get(0)).trim();
    if (str.indexOf(acfp.m(2131693567)) == 0) {
      localSpannableStringBuilder.append(acfp.m(2131693567) + " ");
    }
    for (;;)
    {
      localObject1 = str;
      if (i != 0) {}
      try
      {
        localObject1 = str.toLowerCase().substring(i);
        localSpannableStringBuilder.append(amxk.a((String)localObject1, this.wB));
        if (this.U == null) {
          this.U = localSpannableStringBuilder;
        }
        return this.U;
        if (str.indexOf(acfp.m(2131693571)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693571) + " ");
        }
        else if (str.indexOf(acfp.m(2131693568)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693568) + " ");
          i = 4;
        }
        else if (str.indexOf(acfp.m(2131693572)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693572) + " ");
          i = 4;
        }
        else if (str.indexOf(acfp.m(2131693566)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693566) + " ");
          i = 2;
        }
        else if (str.indexOf(acfp.m(2131693570)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693570) + "  ");
          i = 2;
        }
        else if (str.indexOf(acfp.m(2131693569)) == 0)
        {
          localSpannableStringBuilder.append(acfp.m(2131693569));
          i = 2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = str;
        }
        i = 0;
      }
    }
  }
  
  protected void gK(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    paramView = (BaseActivity)paramView.getContext();
    if (localFileManagerEntity.nFileType == 13)
    {
      aobw.a(localFileManagerEntity.Uuid, paramView, this.mFromType, localFileManagerEntity, paramView.app);
      return;
    }
    agvl localagvl = new agvl(paramView.app, paramView, localFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", false);
    localBundle.putString("c2c_discussion_recentfile", localFileManagerEntity.peerUin);
    if (!TextUtils.isEmpty(this.bIE)) {
      localBundle.putString("file_browser_extra_params_uin", this.bIE);
    }
    localagvl.cB(localBundle);
    paramView = new agvn(paramView, localagvl);
    paramView.Oy(7);
    if (this.mFromType != 0) {
      paramView.Oy(this.mFromType);
    }
    paramView.Jl(acfp.m(2131706226));
    paramView.djN();
  }
  
  protected void gL(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    paramView = (BaseActivity)paramView.getContext();
    if (agmz.b(localFileManagerEntity)) {
      agmz.b(localFileManagerEntity);
    }
    for (;;)
    {
      if ((localFileManagerEntity.cloudType == 3) && (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())))
      {
        ahao.JD(ahav.kY(localFileManagerEntity.fileName) + acfp.m(2131711029));
        agmz.b(localFileManagerEntity);
      }
      return;
      agmz.a(localFileManagerEntity);
      anot.a(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 1, 0, "0", "0", "", "");
    }
  }
  
  protected void gM(View paramView)
  {
    paramView = (BaseActivity)paramView.getContext();
    FileSelectorSearchGroupFragment.a(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("qfile_search_param_ex_params", this.aZ);
    PublicFragmentActivity.startForResult(paramView, localIntent, FileSelectorSearchGroupFragment.class, 9999);
  }
  
  public CharSequence getDescription()
  {
    Object localObject3;
    if (this.mDescription == null)
    {
      if (this.Bw.size() != 1) {
        break label158;
      }
      localObject3 = (FileManagerEntity)this.Bw.get(0);
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(g());
      if (((FileManagerEntity)localObject3).nFileType == 13) {
        break label87;
      }
      ((SpannableStringBuilder)localObject1).append(" ").append(ahav.f((FileManagerEntity)localObject3));
    }
    label87:
    Object localObject2;
    for (;;)
    {
      this.mDescription = ((CharSequence)localObject1);
      return this.mDescription;
      localObject2 = ahcb.bu(((FileManagerEntity)localObject3).srvTime);
      localObject3 = ahav.e((FileManagerEntity)localObject3);
      ((SpannableStringBuilder)localObject1).clear();
      ((SpannableStringBuilder)localObject1).append((String)localObject2 + " " + (String)localObject3 + " " + BaseApplicationImpl.getContext().getString(2131693542));
    }
    label158:
    Object localObject1 = this.Bw.iterator();
    long l = 0L;
    label170:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (l >= ((FileManagerEntity)localObject2).srvTime) {
        break label220;
      }
      l = ((FileManagerEntity)localObject2).srvTime;
    }
    label220:
    for (;;)
    {
      break label170;
      this.mDescription = g();
      break;
    }
  }
  
  public String getFileName()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  public int getFileType()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    if (localFileManagerEntity != null)
    {
      if (localFileManagerEntity.nFileType == 13) {
        return 13;
      }
      return ahav.getFileType(localFileManagerEntity.fileName);
    }
    return 11;
  }
  
  public CharSequence getTitle()
  {
    return amxk.a(((FileManagerEntity)this.Bw.get(0)).fileName.toLowerCase(), this.wB);
  }
  
  public String getUin()
  {
    return null;
  }
  
  public void kI(List<FileManagerEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((!TextUtils.isEmpty(this.bIE)) && (this.bIE.equals(acbn.bkw)))
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
          if (!ahbr.w(localFileManagerEntity)) {
            localArrayList.add(localFileManagerEntity);
          }
        }
        this.Bw.addAll(localArrayList);
      }
    }
    else {
      return;
    }
    this.Bw.addAll(paramList);
  }
  
  public int pG()
  {
    return 0;
  }
  
  public String vp()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Bw.get(0);
    Object localObject1 = "";
    int i = ahav.getFileType(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      localObject1 = localObject2;
      if (!ahbj.fileExistsAndNotEmpty((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!ahbj.fileExistsAndNotEmpty((String)localObject1)) {
        localObject2 = localFileManagerEntity.strThumbPath;
      }
      localObject1 = localObject2;
      if (ahbj.fileExistsAndNotEmpty((String)localObject2)) {}
    }
    for (;;)
    {
      if (localFileManagerEntity.nFileType == 13) {
        localObject1 = aobw.nW(localFileManagerEntity.Uuid);
      }
      return localObject1;
      if (i == 5) {
        localObject1 = localFileManagerEntity.getFilePath();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agon
 * JD-Core Version:    0.7.0.1
 */