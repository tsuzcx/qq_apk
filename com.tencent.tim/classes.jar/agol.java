import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agol
  extends agog
{
  private List<FileInfo> Bv = new ArrayList();
  private CharSequence U;
  private CharSequence mDescription;
  
  public agol(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private String b(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ahcb.bu(paramFileInfo.getDate()));
    localStringBuilder.append("  ");
    localStringBuilder.append(ahbj.g(paramFileInfo.getSize()));
    return localStringBuilder.toString();
  }
  
  public int Ey()
  {
    return this.Bv.size();
  }
  
  public List<ampx> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.Bv.iterator();
    while (paramContext.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramContext.next();
      agol localagol = new agol(this.wB, this.mFromType);
      localagol.cA(this.aZ);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileInfo);
      localagol.kH(localArrayList);
      paramQQAppInterface.add(localagol);
    }
    return paramQQAppInterface;
  }
  
  public boolean alP()
  {
    FileInfo localFileInfo = (FileInfo)this.Bv.get(0);
    if (localFileInfo != null) {
      return agmz.d(localFileInfo);
    }
    return false;
  }
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    if (this.U != null) {
      return this.U;
    }
    int i = this.Bv.size();
    if (i > 1)
    {
      localSpannableStringBuilder = new SpannableStringBuilder(i + acfp.m(2131706230) + "\"");
      localSpannableStringBuilder.append(amxk.a(this.wB, this.wB));
      localSpannableStringBuilder.append("\"").append(acfp.m(2131693575));
      this.U = localSpannableStringBuilder;
      return this.U;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(amxk.a(b((FileInfo)this.Bv.get(0)), this.wB));
    if (this.U == null) {
      this.U = localSpannableStringBuilder;
    }
    return this.U;
  }
  
  protected void gK(View paramView)
  {
    Object localObject = (FileInfo)this.Bv.get(0);
    paramView = (BaseActivity)paramView.getContext();
    localObject = ahav.a((FileInfo)localObject);
    paramView = new agvn(paramView, new agvl(paramView.app, paramView, (FileManagerEntity)localObject, 10000));
    paramView.Oy(8);
    paramView.djN();
  }
  
  protected void gL(View paramView)
  {
    paramView = (FileInfo)this.Bv.get(0);
    if (agmz.d(paramView)) {
      agmz.e(paramView);
    }
    for (;;)
    {
      if (!ahbj.fileExistsAndNotEmpty(paramView.getPath()))
      {
        ahao.JD(ahav.kY(paramView.getName()) + acfp.m(2131711039));
        agmz.e(paramView);
      }
      return;
      agmz.d(paramView);
      anot.a(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
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
    Object localObject;
    if (this.mDescription == null)
    {
      if (this.Bv.size() != 1) {
        break label61;
      }
      localObject = (FileInfo)this.Bv.get(0);
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append(g());
    }
    label61:
    for (this.mDescription = ((CharSequence)localObject);; this.mDescription = g()) {
      return this.mDescription;
    }
  }
  
  public String getFileName()
  {
    FileInfo localFileInfo = (FileInfo)this.Bv.get(0);
    if (localFileInfo != null) {
      return localFileInfo.getName();
    }
    return "";
  }
  
  public int getFileType()
  {
    FileInfo localFileInfo = (FileInfo)this.Bv.get(0);
    if (localFileInfo != null) {
      return ahav.getFileType(localFileInfo.getPath());
    }
    return 11;
  }
  
  public CharSequence getTitle()
  {
    return amxk.a(((FileInfo)this.Bv.get(0)).getName().toLowerCase(), this.wB);
  }
  
  public String getUin()
  {
    return null;
  }
  
  public void kH(List<FileInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.Bv.addAll(paramList);
    }
  }
  
  public int pG()
  {
    return 0;
  }
  
  public String vp()
  {
    FileInfo localFileInfo = (FileInfo)this.Bv.get(0);
    if (localFileInfo != null)
    {
      int i = ahav.getFileType(localFileInfo.getPath());
      if ((i == 0) || (i == 2) || (i == 5)) {
        return localFileInfo.getPath();
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agol
 * JD-Core Version:    0.7.0.1
 */