import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchDetailActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agns
  extends ampy
{
  public List<FileManagerEntity> Br = new ArrayList();
  CharSequence T;
  CharSequence description;
  public int fromType = -1;
  public String keyword;
  public String mUin;
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      amxk.b("all_result", "clk_file", new String[] { "" + this.keyword });
    }
    amxk.a(this.keyword, 100, 0, paramView);
    if (this.Br.size() == 1)
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.Br.get(0);
      Object localObject1 = (BaseActivity)paramView.getContext();
      Object localObject2 = new ahau.a();
      ((ahau.a)localObject2).bJE = "file_viewer_in";
      ((ahau.a)localObject2).cYX = 73;
      ((ahau.a)localObject2).bJF = ahbj.getExtension(localFileManagerEntity.fileName);
      ((ahau.a)localObject2).nFileSize = localFileManagerEntity.fileSize;
      ahau.a(((BaseActivity)localObject1).app.getCurrentAccountUin(), (ahau.a)localObject2);
      ahau.JH("0X8004AE4");
      if (localFileManagerEntity.nFileType == 13)
      {
        aobw.a(localFileManagerEntity.Uuid, (Context)localObject1, this.fromType, localFileManagerEntity, ((BaseActivity)localObject1).app);
        if (this.fromType == 8) {
          anot.a(null, "dc00898", "", "", "0X800A084", "0X800A084", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        ahau.JH("0X8006062");
        amub.a(null, 0, this.fromType, "0x8009D59", 0, 0, null, null);
        return;
        if (this.fromType == 1)
        {
          anot.a(null, "dc00898", "", "", "0X800A086", "0X800A086", 0, 0, "", "", "", "");
          continue;
          localObject2 = new agvl(((BaseActivity)localObject1).app, (Context)localObject1, localFileManagerEntity, 10001);
          Bundle localBundle = new Bundle();
          localBundle.putBoolean("from_qlink_enter_recent", false);
          localBundle.putString("c2c_discussion_recentfile", localFileManagerEntity.peerUin);
          if (!TextUtils.isEmpty(this.mUin)) {
            localBundle.putString("file_browser_extra_params_uin", this.mUin);
          }
          ((agvl)localObject2).cB(localBundle);
          localObject1 = new agvn((Context)localObject1, (agvq)localObject2);
          ((agvn)localObject1).Oy(7);
          if (this.fromType != -1) {
            ((agvn)localObject1).Oy(this.fromType);
          }
          ((agvn)localObject1).Jl(acfp.m(2131706226));
          ((agvn)localObject1).k(ahbr.a(paramView.findViewById(2131367020), localFileManagerEntity.fileName));
          ((agvn)localObject1).djN();
        }
      }
    }
    ahau.JH("0X8006099");
    amub.a(null, 0, this.fromType, "0x8009D5B", 0, 0, null, null);
    FileSearchDetailActivity.a(paramView.getContext(), getKeyword(), this);
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    int i = 7;
    if (this.T != null) {
      return this.T;
    }
    int j = this.Br.size();
    Object localObject1;
    if (j > 1)
    {
      localObject1 = new SpannableStringBuilder(j + acfp.m(2131706230) + "\"");
      ((SpannableStringBuilder)localObject1).append(amxk.a(this.keyword, this.keyword));
      ((SpannableStringBuilder)localObject1).append("\"").append("相关的同名文件记录");
      this.T = ((CharSequence)localObject1);
      return this.T;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = ahav.e((FileManagerEntity)this.Br.get(0)).trim();
    if (str.indexOf(acfp.m(2131706229)) == 0) {
      localSpannableStringBuilder.append("来自多人聊天: ");
    }
    for (;;)
    {
      localObject1 = str;
      if (i != 0) {}
      try
      {
        localObject1 = str.toLowerCase().substring(i);
        localSpannableStringBuilder.append(amxk.a((String)localObject1, this.keyword));
        if (this.T == null) {
          this.T = localSpannableStringBuilder;
        }
        return this.T;
        if (str.indexOf(acfp.m(2131706227)) == 0)
        {
          localSpannableStringBuilder.append("发给多人聊天: ");
        }
        else if (str.indexOf(acfp.m(2131706228)) == 0)
        {
          localSpannableStringBuilder.append("来自群: ");
          i = 4;
        }
        else if (str.indexOf(acfp.m(2131706223)) == 0)
        {
          localSpannableStringBuilder.append("发给群: ");
          i = 4;
        }
        else if (str.indexOf(acfp.m(2131706224)) == 0)
        {
          localSpannableStringBuilder.append("来自 ");
          i = 2;
        }
        else if (str.indexOf(acfp.m(2131706225)) == 0)
        {
          localSpannableStringBuilder.append("发给  ");
          i = 2;
        }
        else if (str.indexOf(acfp.m(2131706222)) == 0)
        {
          localSpannableStringBuilder.append("存到");
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
  
  public CharSequence getDescription()
  {
    Object localObject3;
    if (this.description == null)
    {
      if (this.Br.size() != 1) {
        break label161;
      }
      localObject3 = (FileManagerEntity)this.Br.get(0);
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(g());
      if (((FileManagerEntity)localObject3).nFileType == 13) {
        break label88;
      }
      ((SpannableStringBuilder)localObject1).append(" ").append(ahav.f((FileManagerEntity)localObject3));
    }
    label88:
    Object localObject2;
    for (;;)
    {
      this.description = ((CharSequence)localObject1);
      return this.description;
      localObject2 = ahcb.bu(((FileManagerEntity)localObject3).srvTime);
      localObject3 = ahav.e((FileManagerEntity)localObject3);
      ((SpannableStringBuilder)localObject1).clear();
      ((SpannableStringBuilder)localObject1).append((String)localObject2 + " " + (String)localObject3 + " " + BaseApplicationImpl.getContext().getString(2131693542));
    }
    label161:
    Object localObject1 = this.Br.iterator();
    long l = 0L;
    label173:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (l >= ((FileManagerEntity)localObject2).srvTime) {
        break label223;
      }
      l = ((FileManagerEntity)localObject2).srvTime;
    }
    label223:
    for (;;)
    {
      break label173;
      this.description = g();
      break;
    }
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    CharSequence localCharSequence = amxk.a(((FileManagerEntity)this.Br.get(0)).fileName.toLowerCase(), this.keyword);
    localCharSequence.toString();
    return localCharSequence;
  }
  
  public String getUin()
  {
    return ((FileManagerEntity)this.Br.get(0)).peerUin;
  }
  
  public int pG()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agns
 * JD-Core Version:    0.7.0.1
 */