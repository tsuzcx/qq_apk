import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tribe.async.dispatch.Subscriber;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class wad
  extends vzg
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private uxp jdField_a_of_type_Uxp;
  private vtt jdField_a_of_type_Vtt;
  private vzj jdField_a_of_type_Vzj;
  private wag jdField_a_of_type_Wag;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Vzd);
      if (this.jdField_a_of_type_Vzj != null) {
        this.jdField_a_of_type_Vzj.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Wag != null) {
        this.jdField_a_of_type_Wag.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher.a(paramString1, paramString2, paramBoolean, paramInt1, paramInt2);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 2)) {}
    StoryVideoItem localStoryVideoItem;
    int i;
    label190:
    do
    {
      return;
      localStoryVideoItem = this.jdField_a_of_type_Vtt.a();
      Object localObject2 = this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm;
      i = this.jdField_a_of_type_Vtt.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((uxm)localObject2).jdField_a_of_type_JavaLangString;
        str = ((uxm)localObject2).b;
        int j = ((uxm)localObject2).jdField_a_of_type_Int;
        localObject2 = (uvx)uwa.a(5);
        uwm localuwm = (uwm)uwa.a(2);
        localObject2 = ((uvx)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localuwm.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            wxj.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((uwm)uwa.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      wxj.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Wag == null) {
      this.jdField_a_of_type_Wag = new wag(this);
    }
    localHashMap.put(this.jdField_a_of_type_Wag, "");
    localHashMap.put(new waf(this), "");
    localHashMap.put(new wae(this), "");
    return localHashMap;
  }
  
  public Set<vrx> a()
  {
    HashSet localHashSet = new HashSet(1);
    vzj localvzj = new vzj();
    this.jdField_a_of_type_Vzj = localvzj;
    localHashSet.add(localvzj);
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
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    this.jdField_a_of_type_Vtt = paramvtt;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramvtt.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    uxp localuxp = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((uxp)localObject).jdField_a_of_type_Uxm != null) && (!TextUtils.isEmpty(((uxp)localObject).jdField_a_of_type_Uxm.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Uxp = ((uxp)localObject);
      wxe.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramvtt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uxp.b, this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm.b, Integer.valueOf(this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm.jdField_a_of_type_Int), this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Vzd.j();
      localObject = this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxm;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvtt.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramvzh.b.setVisibility(0);
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramvtt = this.jdField_a_of_type_Uxp.b;
      if (TextUtils.isEmpty(paramvtt)) {
        break label503;
      }
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(paramvtt);
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramvtt);
      paramvzh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845980);
      if ((localObject != null) && (!TextUtils.isEmpty(((uxm)localObject).jdField_c_of_type_JavaLangString))) {
        vzd.a(((uxm)localObject).jdField_c_of_type_JavaLangString, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130845980), paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
      }
      paramvzh = ((uwm)uwa.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramvzh == null) || (!paramvzh.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((uxm)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramvzh = "2";
        label362:
        if (localObject == null) {
          break label549;
        }
      }
    }
    label532:
    label537:
    label543:
    label549:
    for (paramvtt = ((uxm)localObject).b;; paramvtt = "")
    {
      wxj.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramvzh, paramvtt, "", localStoryVideoItem.mVid });
      return;
      if ((localuxp != null) && (localuxp.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Uxp = localuxp;
        wxe.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramvtt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Uxp.b);
        break;
      }
      wxe.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramvtt.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Vzd.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Uxp = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramvtt.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131701826));
      paramvzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131701827));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramvzh = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wad
 * JD-Core Version:    0.7.0.1
 */