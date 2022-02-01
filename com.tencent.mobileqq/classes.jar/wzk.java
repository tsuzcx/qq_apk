import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class wzk
  extends wxx
{
  private String jdField_a_of_type_JavaLangString;
  private wsk jdField_a_of_type_Wsk;
  private String b = "";
  private boolean c;
  
  private vwl a(StoryVideoItem paramStoryVideoItem)
  {
    vwm localvwm = paramStoryVideoItem.getOALinkInfo();
    if ((localvwm != null) && (localvwm.a != null))
    {
      xvv.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    xvv.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<wqo> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new wzl(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Wsk != null) && (this.jdField_a_of_type_Wsk.a().isGameVideo())) {
      xwa.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wsk.a().mVid });
    }
    return true;
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    this.jdField_a_of_type_Wsk = paramwsk;
    Object localObject2 = paramwsk.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Wxu.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((vwk)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramwxy.c.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839652);
    paramwxy.jdField_a_of_type_AndroidViewView.setPadding(paramwxy.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramwxy.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramwxy.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramwxy.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((vvj)vux.a(2)).b(paramwsk.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((vwl)localObject1).d;
      localObject2 = ((vwl)localObject1).e;
      localObject1 = ((vwl)localObject1).f;
      localObject3 = paramwxy.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label332;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      wxu.a(str, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramwsk.jdField_a_of_type_JavaLangString)) {
        break label341;
      }
      this.c = false;
    }
    for (;;)
    {
      if (this.c) {
        xwa.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wsk.a().mVid });
      }
      return;
      str = ((vwl)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((vwl)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((vwl)localObject1).c;
        break;
      }
      localObject1 = amtj.a(2131704141);
      break;
      label332:
      localObject1 = amtj.a(2131704140);
      break label176;
      label341:
      this.c = true;
      if (!blig.a(this.jdField_a_of_type_Wxu.b())) {
        blig.a(this.jdField_a_of_type_Wxu.b());
      }
      this.b = paramwsk.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzk
 * JD-Core Version:    0.7.0.1
 */