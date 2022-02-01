import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vqn
  extends uyw<vpj>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View b;
  
  public vqn(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    if (paramvrn != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramvrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.cid));
  }
  
  private boolean c()
  {
    return (this.b != null) && (this.b.getVisibility() == 0) && (!a());
  }
  
  private void g()
  {
    vnr.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  protected void a()
  {
    vpj localvpj = (vpj)a();
    if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localvpj.a());
    }
  }
  
  public boolean a()
  {
    return (a() != null) && (((vpj)a()).a());
  }
  
  protected int b()
  {
    return 2131560072;
  }
  
  protected void b()
  {
    if (b())
    {
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.name);
      if (a())
      {
        this.b.setBackgroundColor(vmg.b(2131165751));
        return;
      }
      this.b.setBackgroundColor(vmg.b(2131165368));
      return;
    }
    this.b.setVisibility(8);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.b = a(2131380746);
    this.b.setOnClickListener(new vqo(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380747));
  }
  
  public void f()
  {
    if (!c())
    {
      vmp.d("AbsWsUIGroup", "fail to meet the requirement of playing collection animation");
      return;
    }
    if (a() != null) {
      ((vpj)a()).a(true);
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this.b, "backgroundColor", new int[] { -2147483648, -2139470081 });
    localObjectAnimator.addListener(new vqp(this));
    localObjectAnimator.setDuration(500L);
    localObjectAnimator.setEvaluator(new ArgbEvaluator());
    localObjectAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqn
 * JD-Core Version:    0.7.0.1
 */