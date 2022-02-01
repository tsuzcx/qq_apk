import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class xof
  extends xms
{
  private String jdField_a_of_type_JavaLangString;
  private xhf jdField_a_of_type_Xhf;
  private String b = "";
  private boolean c;
  
  private wlg a(StoryVideoItem paramStoryVideoItem)
  {
    wlh localwlh = paramStoryVideoItem.getOALinkInfo();
    if ((localwlh != null) && (localwlh.a != null))
    {
      ykq.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    ykq.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<xfj> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new xog(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Xhf != null) && (this.jdField_a_of_type_Xhf.a().isGameVideo())) {
      ykv.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xhf.a().mVid });
    }
    return true;
  }
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    this.jdField_a_of_type_Xhf = paramxhf;
    Object localObject2 = paramxhf.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Xmp.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((wlf)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramxmt.c.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839673);
    paramxmt.jdField_a_of_type_AndroidViewView.setPadding(paramxmt.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramxmt.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramxmt.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramxmt.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((wke)wjs.a(2)).b(paramxhf.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((wlg)localObject1).d;
      localObject2 = ((wlg)localObject1).e;
      localObject1 = ((wlg)localObject1).f;
      localObject3 = paramxmt.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label332;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      xmp.a(str, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramxhf.jdField_a_of_type_JavaLangString)) {
        break label341;
      }
      this.c = false;
    }
    for (;;)
    {
      if (this.c) {
        ykv.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Xhf.a().mVid });
      }
      return;
      str = ((wlg)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((wlg)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((wlg)localObject1).c;
        break;
      }
      localObject1 = anvx.a(2131704492);
      break;
      label332:
      localObject1 = anvx.a(2131704491);
      break label176;
      label341:
      this.c = true;
      if (!bmux.a(this.jdField_a_of_type_Xmp.b())) {
        bmux.a(this.jdField_a_of_type_Xmp.b());
      }
      this.b = paramxhf.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xof
 * JD-Core Version:    0.7.0.1
 */