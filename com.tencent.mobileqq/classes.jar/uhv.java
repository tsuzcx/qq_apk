import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class uhv
  extends ugi
{
  private String jdField_a_of_type_JavaLangString;
  private uav jdField_a_of_type_Uav;
  private String b = "";
  private boolean c;
  
  private teq a(StoryVideoItem paramStoryVideoItem)
  {
    ter localter = paramStoryVideoItem.getOALinkInfo();
    if ((localter != null) && (localter.a != null))
    {
      veg.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    veg.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<tyz> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new uhw(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Uav != null) && (this.jdField_a_of_type_Uav.a().isGameVideo())) {
      vel.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uav.a().mVid });
    }
    return true;
  }
  
  public void b(ugj paramugj, uav paramuav)
  {
    this.jdField_a_of_type_Uav = paramuav;
    Object localObject2 = paramuav.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Ugf.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((tep)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramugj.c.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839349);
    paramugj.jdField_a_of_type_AndroidViewView.setPadding(paramugj.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramugj.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramugj.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramugj.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((tdo)tdc.a(2)).b(paramuav.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((teq)localObject1).d;
      localObject2 = ((teq)localObject1).e;
      localObject1 = ((teq)localObject1).f;
      localObject3 = paramugj.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ugf.a(str, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramugj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramuav.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Uav != null)) {
        vel.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uav.a().mVid });
      }
      return;
      str = ((teq)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((teq)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((teq)localObject1).c;
        break;
      }
      localObject1 = ajyc.a(2131705014);
      break;
      label339:
      localObject1 = ajyc.a(2131705013);
      break label176;
      label348:
      this.c = true;
      if (!bihe.a(this.jdField_a_of_type_Ugf.b())) {
        bihe.a(this.jdField_a_of_type_Ugf.b());
      }
      this.b = paramuav.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhv
 * JD-Core Version:    0.7.0.1
 */