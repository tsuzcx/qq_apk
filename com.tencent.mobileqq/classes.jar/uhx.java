import UserGrowth.stFeed;
import UserGrowth.stQQGroupInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.GroupDlgView;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import java.util.ArrayList;
import java.util.List;

public class uhx
  extends uej
{
  private static final int d = bhtq.b(1.0F);
  private static final int e = bhtq.b(14.0F);
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private uhz jdField_a_of_type_Uhz;
  
  public uhx(Context paramContext, uhz paramuhz)
  {
    super(paramContext);
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
    this.jdField_a_of_type_Uhz = paramuhz;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Uhz != null) {
        this.jdField_a_of_type_Uhz.b();
      }
      uhp localuhp = new uhp(this.jdField_a_of_type_AndroidAppActivity);
      GroupDlgView localGroupDlgView = new GroupDlgView(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Uhz);
      localuhp.setContentView(localGroupDlgView);
      localGroupDlgView.a(a(this.jdField_a_of_type_Uhz.a()));
      localuhp.show();
    } while (this.jdField_a_of_type_Uhz == null);
    this.jdField_a_of_type_Uhz.a();
  }
  
  public List<uhv> a(stFeed paramstFeed)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramstFeed != null) && (paramstFeed.feed != null) && (paramstFeed.feed.qqGroups != null) && (paramstFeed.feed.qqGroups.size() > 0))
    {
      int i = 0;
      while (i < paramstFeed.feed.qqGroups.size())
      {
        stQQGroupInfo localstQQGroupInfo = (stQQGroupInfo)paramstFeed.feed.qqGroups.get(i);
        localArrayList.add(new uhv(localstQQGroupInfo.groupAvatar, localstQQGroupInfo.groupName, localstQQGroupInfo.groupCode, localstQQGroupInfo.groupAuth));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560393;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131368894));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131368892));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368893));
    Drawable localDrawable = a().getDrawable(2130842651);
    localDrawable.setBounds(new Rect(0, 0, e, e));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(d);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, localDrawable, null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new uhy(this));
  }
  
  public void f()
  {
    stFeed localstFeed = this.jdField_a_of_type_Uhz.a();
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) && (localstFeed != null) && (localstFeed.feed != null) && (localstFeed.feed.qqGroups != null) && (localstFeed.feed.qqGroups.size() > 0)) {
      uqt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, ((stQQGroupInfo)localstFeed.feed.qqGroups.get(0)).groupAvatar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhx
 * JD-Core Version:    0.7.0.1
 */