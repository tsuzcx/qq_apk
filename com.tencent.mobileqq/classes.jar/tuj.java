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

public class tuj
  extends ttm
{
  private int jdField_a_of_type_Int;
  private FollowCaptureLauncher jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher;
  private String jdField_a_of_type_JavaLangString = "";
  private srv jdField_a_of_type_Srv;
  private tnz jdField_a_of_type_Tnz;
  private ttp jdField_a_of_type_Ttp;
  private tum jdField_a_of_type_Tum;
  private String b;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher = new FollowCaptureLauncher(this.jdField_a_of_type_Ttj);
      if (this.jdField_a_of_type_Ttp != null) {
        this.jdField_a_of_type_Ttp.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
      }
      if (this.jdField_a_of_type_Tum != null) {
        this.jdField_a_of_type_Tum.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoFollowCaptureLauncher);
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
      localStoryVideoItem = this.jdField_a_of_type_Tnz.a();
      Object localObject2 = this.jdField_a_of_type_Srv.jdField_a_of_type_Srs;
      i = this.jdField_a_of_type_Tnz.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((srs)localObject2).jdField_a_of_type_JavaLangString;
        str = ((srs)localObject2).b;
        int j = ((srs)localObject2).jdField_a_of_type_Int;
        localObject2 = (sqd)sqg.a(5);
        sqs localsqs = (sqs)sqg.a(2);
        localObject2 = ((sqd)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localsqs.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            urp.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((sqs)sqg.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      urp.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Tum == null) {
      this.jdField_a_of_type_Tum = new tum(this);
    }
    localHashMap.put(this.jdField_a_of_type_Tum, "");
    localHashMap.put(new tul(this), "");
    localHashMap.put(new tuk(this), "");
    return localHashMap;
  }
  
  public Set<tmd> a()
  {
    HashSet localHashSet = new HashSet(1);
    ttp localttp = new ttp();
    this.jdField_a_of_type_Ttp = localttp;
    localHashSet.add(localttp);
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
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    this.jdField_a_of_type_Tnz = paramtnz;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramtnz.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    srv localsrv = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((srv)localObject).jdField_a_of_type_Srs != null) && (!TextUtils.isEmpty(((srv)localObject).jdField_a_of_type_Srs.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Srv = ((srv)localObject);
      urk.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramtnz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Srv.b, this.jdField_a_of_type_Srv.jdField_a_of_type_Srs.b, Integer.valueOf(this.jdField_a_of_type_Srv.jdField_a_of_type_Srs.jdField_a_of_type_Int), this.jdField_a_of_type_Srv.jdField_a_of_type_Srs.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Srv.jdField_a_of_type_Srs.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Ttj.j();
      localObject = this.jdField_a_of_type_Srv.jdField_a_of_type_Srs;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramtnz.jdField_a_of_type_JavaLangString)) {
        break label487;
      }
      this.jdField_c_of_type_Boolean = false;
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramttn.b.setVisibility(0);
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramtnz = this.jdField_a_of_type_Srv.b;
      if (TextUtils.isEmpty(paramtnz)) {
        break label503;
      }
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(paramtnz);
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramtnz);
      paramttn.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845338);
      if ((localObject != null) && (!TextUtils.isEmpty(((srs)localObject).jdField_c_of_type_JavaLangString))) {
        ttj.a(((srs)localObject).jdField_c_of_type_JavaLangString, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130845338), paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
      }
      paramttn = ((sqs)sqg.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramttn == null) || (!paramttn.isVip)) {
          break label532;
        }
        i = 1;
        if (localObject == null) {
          break label537;
        }
        j = ((srs)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label543;
        }
        paramttn = "2";
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
    for (paramtnz = ((srs)localObject).b;; paramtnz = "")
    {
      urp.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramttn, paramtnz, "", localStoryVideoItem.mVid });
      return;
      if ((localsrv != null) && (localsrv.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Srv = localsrv;
        urk.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramtnz.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Srv.b);
        break;
      }
      urk.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramtnz.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Ttj.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Srv = null;
      return;
      label487:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramtnz.jdField_a_of_type_JavaLangString;
      break label192;
      label503:
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635646));
      paramttn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131635647));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramttn = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuj
 * JD-Core Version:    0.7.0.1
 */