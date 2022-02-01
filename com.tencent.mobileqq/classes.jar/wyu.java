import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class wyu
  extends wxx
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private vwm jdField_a_of_type_Vwm;
  private wsk jdField_a_of_type_Wsk;
  private wya jdField_a_of_type_Wya;
  private wyx jdField_a_of_type_Wyx;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  private void b()
  {
    if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {}
    StoryVideoItem localStoryVideoItem;
    int i;
    label190:
    do
    {
      return;
      localStoryVideoItem = this.jdField_a_of_type_Wsk.a();
      Object localObject2 = this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj;
      i = this.jdField_a_of_type_Wsk.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((vwj)localObject2).jdField_a_of_type_JavaLangString;
        str = ((vwj)localObject2).b;
        int j = ((vwj)localObject2).jdField_a_of_type_Int;
        localObject2 = (vuu)vux.a(5);
        vvj localvvj = (vvj)vux.a(2);
        localObject2 = ((vuu)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localvvj.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            xwa.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
            return;
            i = 0;
            break;
          }
        }
        this.b = str;
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    String str = localStoryVideoItem.mVid;
    a(str, "", true, i, 0);
    Object localObject1 = ((vvj)vux.a(2)).b(localStoryVideoItem.mOwnerUid);
    if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
    {
      i = 1;
      if (i == 0) {
        break label311;
      }
    }
    label311:
    for (localObject1 = "2";; localObject1 = "1")
    {
      xwa.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Wyx == null) {
      this.jdField_a_of_type_Wyx = new wyx(this);
    }
    localHashMap.put(this.jdField_a_of_type_Wyx, "");
    localHashMap.put(new wyw(this), "");
    localHashMap.put(new wyv(this), "");
    return localHashMap;
  }
  
  public Set<wqo> a()
  {
    HashSet localHashSet = new HashSet(1);
    wya localwya = new wya();
    this.jdField_a_of_type_Wya = localwya;
    localHashSet.add(localwya);
    return localHashSet;
  }
  
  public boolean a(View paramView)
  {
    if (!super.a(paramView)) {
      return false;
    }
    b();
    return true;
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    this.jdField_a_of_type_Wsk = paramwsk;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramwsk.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    vwm localvwm = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((vwm)localObject).jdField_a_of_type_Vwj != null) && (!TextUtils.isEmpty(((vwm)localObject).jdField_a_of_type_Vwj.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Vwm = ((vwm)localObject);
      xvv.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramwsk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vwm.b, this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj.b, Integer.valueOf(this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj.jdField_a_of_type_Int), this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Wxu.j();
      localObject = this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwj;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramwsk.jdField_a_of_type_JavaLangString)) {
        break label486;
      }
      this.jdField_c_of_type_Boolean = false;
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramwxy.b.setVisibility(0);
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramwsk = this.jdField_a_of_type_Vwm.b;
      if (TextUtils.isEmpty(paramwsk)) {
        break label502;
      }
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(paramwsk);
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramwsk);
      paramwxy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846344);
      if ((localObject != null) && (!TextUtils.isEmpty(((vwj)localObject).jdField_c_of_type_JavaLangString))) {
        wxu.a(((vwj)localObject).jdField_c_of_type_JavaLangString, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130846344), paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
      }
      paramwxy = ((vvj)vux.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramwxy == null) || (!paramwxy.isVip)) {
          break label531;
        }
        i = 1;
        if (localObject == null) {
          break label536;
        }
        j = ((vwj)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label542;
        }
        paramwxy = "2";
        label362:
        if (localObject == null) {
          break label548;
        }
      }
    }
    label531:
    label536:
    label542:
    label548:
    for (paramwsk = ((vwj)localObject).b;; paramwsk = "")
    {
      xwa.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramwxy, paramwsk, "", localStoryVideoItem.mVid });
      return;
      if ((localvwm != null) && (localvwm.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Vwm = localvwm;
        xvv.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramwsk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Vwm.b);
        break;
      }
      xvv.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramwsk.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Wxu.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Vwm = null;
      return;
      label486:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramwsk.jdField_a_of_type_JavaLangString;
      break label192;
      label502:
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(amtj.a(2131700588));
      paramwxy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131700589));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramwxy = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */