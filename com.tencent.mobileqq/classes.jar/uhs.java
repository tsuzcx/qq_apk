import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class uhs
  extends ugf
{
  private String jdField_a_of_type_JavaLangString;
  private uas jdField_a_of_type_Uas;
  private String b = "";
  private boolean c;
  
  private ten a(StoryVideoItem paramStoryVideoItem)
  {
    teo localteo = paramStoryVideoItem.getOALinkInfo();
    if ((localteo != null) && (localteo.a != null))
    {
      ved.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    ved.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<tyw> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new uht(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Uas != null) && (this.jdField_a_of_type_Uas.a().isGameVideo())) {
      vei.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uas.a().mVid });
    }
    return true;
  }
  
  public void b(ugg paramugg, uas paramuas)
  {
    this.jdField_a_of_type_Uas = paramuas;
    Object localObject2 = paramuas.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Ugc.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((tem)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramugg.c.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839349);
    paramugg.jdField_a_of_type_AndroidViewView.setPadding(paramugg.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramugg.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramugg.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramugg.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((tdl)tcz.a(2)).b(paramuas.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((ten)localObject1).d;
      localObject2 = ((ten)localObject1).e;
      localObject1 = ((ten)localObject1).f;
      localObject3 = paramugg.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      ugc.a(str, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramuas.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Uas != null)) {
        vei.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uas.a().mVid });
      }
      return;
      str = ((ten)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((ten)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((ten)localObject1).c;
        break;
      }
      localObject1 = ajya.a(2131705025);
      break;
      label339:
      localObject1 = ajya.a(2131705024);
      break label176;
      label348:
      this.c = true;
      if (!bihv.a(this.jdField_a_of_type_Ugc.b())) {
        bihv.a(this.jdField_a_of_type_Ugc.b());
      }
      this.b = paramuas.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhs
 * JD-Core Version:    0.7.0.1
 */