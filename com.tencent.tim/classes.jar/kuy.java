import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class kuy
  implements ktr.d
{
  private Set<String> N = new HashSet();
  private String TAG = "GuideHelper";
  private int aLY = 10;
  private int aLZ;
  private boolean ahY;
  private ArticleInfo articleInfo;
  private String scheme;
  
  private void a(String paramString, ArticleInfo paramArticleInfo)
  {
    kxm.b localb = new kxm.b();
    localb.j().b("wording", "" + kyq.iZ());
    ksz.a(paramString, paramArticleInfo, localb);
  }
  
  public boolean AC()
  {
    return this.ahY;
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, ktm paramktm)
  {
    if (!c(paramktm)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramktm.articleInfo.innerUniqueID)) && (!this.N.contains(paramktm.articleInfo.innerUniqueID)))
    {
      a("0X8009FE9", paramktm.articleInfo);
      this.N.add(paramktm.articleInfo.innerUniqueID);
    }
    this.ahY = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131299233));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new kuz(this, paramktm, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131560505, null);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.ahY = paramBoolean;
    this.aLZ = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131299231));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.articleInfo = paramArticleInfo;
  }
  
  public boolean c(ktm paramktm)
  {
    return (paramktm != null) && (paramktm.type == 6);
  }
  
  public void mz(String paramString)
  {
    QLog.d(this.TAG, 1, "extraInfo : " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.scheme = new JSONObject(paramString).getString("app_schema");
      QLog.d(this.TAG, 1, "scheme : " + this.scheme);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d(this.TAG, 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, ktm paramktm, List<ktm> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, ktm paramktm, boolean paramBoolean2, List<ktm> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, ktm paramktm, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.aLZ = 1;
    q(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.aLZ += 1;
    q(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, ktm paramktm) {}
  
  public void onCommentStateError(int paramInt) {}
  
  public void pR(int paramInt)
  {
    QLog.d(this.TAG, 1, "showGuidePagerNum : " + paramInt);
    this.aLY = paramInt;
  }
  
  public boolean q(List<ktm> paramList)
  {
    int i = this.aLZ;
    if ((!TextUtils.isEmpty(this.scheme)) && (i > this.aLY) && (paramList != null))
    {
      ktm localktm = new ktm(6, null, this.articleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((ktm)localIterator.next()).type == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localktm);
      QLog.d(this.TAG, 1, "addGuidePager : " + i + "  articleInfo :" + this.articleInfo);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kuy
 * JD-Core Version:    0.7.0.1
 */