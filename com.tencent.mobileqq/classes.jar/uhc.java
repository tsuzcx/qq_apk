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

public class uhc
  extends ugf
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private teo jdField_a_of_type_Teo;
  private uas jdField_a_of_type_Uas;
  private ugi jdField_a_of_type_Ugi;
  private uhf jdField_a_of_type_Uhf;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Ugc);
      if (this.jdField_a_of_type_Ugi != null) {
        this.jdField_a_of_type_Ugi.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Uhf != null) {
        this.jdField_a_of_type_Uhf.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
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
      localStoryVideoItem = this.jdField_a_of_type_Uas.a();
      Object localObject2 = this.jdField_a_of_type_Teo.jdField_a_of_type_Tel;
      i = this.jdField_a_of_type_Uas.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((tel)localObject2).jdField_a_of_type_JavaLangString;
        str = ((tel)localObject2).b;
        int j = ((tel)localObject2).jdField_a_of_type_Int;
        localObject2 = (tcw)tcz.a(5);
        tdl localtdl = (tdl)tcz.a(2);
        localObject2 = ((tcw)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localtdl.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            vei.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((tdl)tcz.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      vei.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Uhf == null) {
      this.jdField_a_of_type_Uhf = new uhf(this);
    }
    localHashMap.put(this.jdField_a_of_type_Uhf, "");
    localHashMap.put(new uhe(this), "");
    localHashMap.put(new uhd(this), "");
    return localHashMap;
  }
  
  public Set<tyw> a()
  {
    HashSet localHashSet = new HashSet(1);
    ugi localugi = new ugi();
    this.jdField_a_of_type_Ugi = localugi;
    localHashSet.add(localugi);
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
  
  public void b(ugg paramugg, uas paramuas)
  {
    this.jdField_a_of_type_Uas = paramuas;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramuas.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    teo localteo = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((teo)localObject).jdField_a_of_type_Tel != null) && (!TextUtils.isEmpty(((teo)localObject).jdField_a_of_type_Tel.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Teo = ((teo)localObject);
      ved.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramuas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Teo.b, this.jdField_a_of_type_Teo.jdField_a_of_type_Tel.b, Integer.valueOf(this.jdField_a_of_type_Teo.jdField_a_of_type_Tel.jdField_a_of_type_Int), this.jdField_a_of_type_Teo.jdField_a_of_type_Tel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Teo.jdField_a_of_type_Tel.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Ugc.j();
      localObject = this.jdField_a_of_type_Teo.jdField_a_of_type_Tel;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuas.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramugg.b.setVisibility(0);
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramuas = this.jdField_a_of_type_Teo.b;
      if (TextUtils.isEmpty(paramuas)) {
        break label503;
      }
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(paramuas);
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramuas);
      paramugg.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845528);
      if ((localObject != null) && (!TextUtils.isEmpty(((tel)localObject).jdField_c_of_type_JavaLangString))) {
        ugc.a(((tel)localObject).jdField_c_of_type_JavaLangString, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130845528), paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
      }
      paramugg = ((tdl)tcz.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramugg == null) || (!paramugg.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((tel)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramugg = "2";
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
    for (paramuas = ((tel)localObject).b;; paramuas = "")
    {
      vei.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramugg, paramuas, "", localStoryVideoItem.mVid });
      return;
      if ((localteo != null) && (localteo.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Teo = localteo;
        ved.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramuas.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Teo.b);
        break;
      }
      ved.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramuas.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ugc.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Teo = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramuas.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131701441));
      paramugg.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajya.a(2131701442));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramugg = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhc
 * JD-Core Version:    0.7.0.1
 */