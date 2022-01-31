import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.HashSet;
import java.util.Set;

public class wat
  extends vzg
{
  private String jdField_a_of_type_JavaLangString;
  private vtt jdField_a_of_type_Vtt;
  private String b = "";
  private boolean c;
  
  private uxo a(StoryVideoItem paramStoryVideoItem)
  {
    uxp localuxp = paramStoryVideoItem.getOALinkInfo();
    if ((localuxp != null) && (localuxp.a != null))
    {
      wxe.b("GameBannerVideoInfoBuilder", "parse game link info from oa");
      return paramStoryVideoItem.getOALinkInfo().a;
    }
    wxe.b("GameBannerVideoInfoBuilder", "parse game link info from extern");
    return paramStoryVideoItem.getVideoLinkInfo().a;
  }
  
  public Set<vrx> a()
  {
    HashSet localHashSet = new HashSet(1);
    localHashSet.add(new wau(this));
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    if ((this.jdField_a_of_type_Vtt != null) && (this.jdField_a_of_type_Vtt.a().isGameVideo())) {
      wxj.a("video_game", "clk_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vtt.a().mVid });
    }
    return true;
  }
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    this.jdField_a_of_type_Vtt = paramvtt;
    Object localObject2 = paramvtt.a();
    Object localObject1 = a((StoryVideoItem)localObject2);
    this.jdField_a_of_type_Vzd.k();
    localObject2 = ((StoryVideoItem)localObject2).getVideoGameInfo();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaLangString = ((uxn)localObject2).jdField_a_of_type_JavaLangString;
    }
    paramvzh.c.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839431);
    paramvzh.jdField_a_of_type_AndroidViewView.setPadding(paramvzh.jdField_a_of_type_AndroidViewView.getPaddingLeft(), paramvzh.jdField_a_of_type_AndroidViewView.getPaddingTop(), paramvzh.jdField_a_of_type_AndroidViewView.getPaddingRight(), paramvzh.jdField_a_of_type_AndroidViewView.getPaddingBottom());
    Object localObject3 = ((uwm)uwa.a(2)).b(paramvtt.a().mOwnerUid);
    String str;
    if ((localObject3 != null) && (((QQUserUIItem)localObject3).isMe()))
    {
      str = ((uxo)localObject1).d;
      localObject2 = ((uxo)localObject1).e;
      localObject1 = ((uxo)localObject1).f;
      localObject3 = paramvzh.c;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label339;
      }
      label176:
      ((TextView)localObject3).setText((CharSequence)localObject1);
      vzd.a(str, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      if (!TextUtils.equals(this.b, paramvtt.jdField_a_of_type_JavaLangString)) {
        break label348;
      }
      this.c = false;
    }
    for (;;)
    {
      if ((this.c) && (this.jdField_a_of_type_Vtt != null)) {
        wxj.a("video_game", "exp_url", 0, 0, new String[] { "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vtt.a().mVid });
      }
      return;
      str = ((uxo)localObject1).jdField_a_of_type_JavaLangString;
      localObject2 = ((uxo)localObject1).b;
      if ((localObject3 != null) && (((QQUserUIItem)localObject3).isFriend()))
      {
        localObject1 = ((uxo)localObject1).c;
        break;
      }
      localObject1 = alud.a(2131705409);
      break;
      label339:
      localObject1 = alud.a(2131705408);
      break label176;
      label348:
      this.c = true;
      if (!bkny.a(this.jdField_a_of_type_Vzd.b())) {
        bkny.a(this.jdField_a_of_type_Vzd.b());
      }
      this.b = paramvtt.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */