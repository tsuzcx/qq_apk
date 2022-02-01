import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.util.HashSet;
import java.util.Set;

public class kva
  extends PopupWindow
{
  private Set<String> O = new HashSet();
  public final String TAG = "GuidePopuppWindow";
  private final int aMa = 0;
  private int aMb = 0;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private kva.a jdField_b_of_type_Kva$a;
  private Container d;
  public final float jg = 1.0F;
  public final float jh = 1.0F;
  private Activity mActivity;
  private VafContext mVafContext;
  
  public kva(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    c(getVafContext());
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(false);
    setInputMethodMode(1);
    setBackgroundDrawable(new ColorDrawable(0));
    aHq();
  }
  
  private void c(VafContext paramVafContext)
  {
    TemplateBean localTemplateBean = kyq.a(paramVafContext);
    this.d = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
    kvx.a(this.d.getVirtualView(), localTemplateBean.getViewBean());
    setContentView(this.d);
    paramVafContext = this.d.getVirtualView().getComLayoutParams();
    setHeight(paramVafContext.mLayoutHeight);
    setWidth(paramVafContext.mLayoutWidth);
  }
  
  public void a(kva.a parama)
  {
    this.jdField_b_of_type_Kva$a = parama;
  }
  
  public void aHq()
  {
    setOnDismissListener(new kvb(this));
    if (this.d != null) {
      b(this.d);
    }
  }
  
  public void aO(View paramView)
  {
    if (isShowing())
    {
      dismiss();
      return;
    }
    this.O.add(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    pS(0);
    i(1.0F);
    setAnimationStyle(2131755044);
    showAtLocation(paramView, 17, 0, 0);
    paramView = new kxm.b();
    paramView.j().b("wording", "" + kyq.iZ());
    ksz.a("0X8009FE7", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void b(Container paramContainer)
  {
    if (paramContainer == null) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new kvc(this));
  }
  
  public boolean dw(String paramString)
  {
    return this.O.contains(paramString);
  }
  
  public VafContext getVafContext()
  {
    if (this.mVafContext == null)
    {
      this.mVafContext = new luh();
      this.mVafContext.setCurActivity(this.mActivity);
      this.mVafContext.setContext(this.mActivity);
      kvx.a(this.mVafContext, "comment_feeds");
    }
    return this.mVafContext;
  }
  
  protected void i(float paramFloat)
  {
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.alpha = paramFloat;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public void pS(int paramInt)
  {
    this.aMb = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void pE(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kva
 * JD-Core Version:    0.7.0.1
 */