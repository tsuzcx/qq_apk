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

public class xnp
  extends xms
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "";
  private wlh jdField_a_of_type_Wlh;
  private xhf jdField_a_of_type_Xhf;
  private xmv jdField_a_of_type_Xmv;
  private xns jdField_a_of_type_Xns;
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
      localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
      Object localObject2 = this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle;
      i = this.jdField_a_of_type_Xhf.a().comparedLevel;
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject1 = ((wle)localObject2).jdField_a_of_type_JavaLangString;
        str = ((wle)localObject2).b;
        int j = ((wle)localObject2).jdField_a_of_type_Int;
        localObject2 = (wjp)wjs.a(5);
        wke localwke = (wke)wjs.a(2);
        localObject2 = ((wjp)localObject2).b(str);
        if (localObject2 != null)
        {
          a(str, (String)localObject1, false, i, j);
          localObject1 = localwke.b(((StoryVideoItem)localObject2).mOwnerUid);
          if ((localObject1 != null) && (((QQUserUIItem)localObject1).isVip))
          {
            i = 1;
            if (i == 0) {
              break label190;
            }
          }
          for (localObject1 = "2";; localObject1 = "1")
          {
            ykv.a("play_video", "multishoot_entry_clk", 0, j, new String[] { localObject1, str, ((StoryVideoItem)localObject2).mOwnerUid, localStoryVideoItem.mVid });
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
    Object localObject1 = ((wke)wjs.a(2)).b(localStoryVideoItem.mOwnerUid);
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
      ykv.a("play_video", "multishoot_entry_clk", 0, 0, new String[] { localObject1, str, localStoryVideoItem.mOwnerUid, str });
      return;
      i = 0;
      break;
    }
  }
  
  public Map<Subscriber, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Xns == null) {
      this.jdField_a_of_type_Xns = new xns(this);
    }
    localHashMap.put(this.jdField_a_of_type_Xns, "");
    localHashMap.put(new xnr(this), "");
    localHashMap.put(new xnq(this), "");
    return localHashMap;
  }
  
  public Set<xfj> a()
  {
    HashSet localHashSet = new HashSet(1);
    xmv localxmv = new xmv();
    this.jdField_a_of_type_Xmv = localxmv;
    localHashSet.add(localxmv);
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
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    this.jdField_a_of_type_Xhf = paramxhf;
    this.b = null;
    this.jdField_c_of_type_JavaLangString = null;
    StoryVideoItem localStoryVideoItem = paramxhf.a();
    Object localObject = localStoryVideoItem.getOALinkInfo();
    wlh localwlh = localStoryVideoItem.getVideoLinkInfo();
    label192:
    label247:
    int i;
    label343:
    int j;
    if ((localObject != null) && (((wlh)localObject).jdField_a_of_type_Wle != null) && (!TextUtils.isEmpty(((wlh)localObject).jdField_a_of_type_Wle.b)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Wlh = ((wlh)localObject);
      ykq.b("CaptureTogetherBannerVideoInfoController", "get video link info from oa, vid:%s, title:%s, comp_vid:%s, oa_task_id:%s, bg_url:%s, icon_url:%s", new Object[] { paramxhf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wlh.b, this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle.b, Integer.valueOf(this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle.jdField_a_of_type_Int), this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle.jdField_c_of_type_JavaLangString });
      this.jdField_a_of_type_Xmp.j();
      localObject = this.jdField_a_of_type_Wlh.jdField_a_of_type_Wle;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxhf.jdField_a_of_type_JavaLangString)) {
        break label486;
      }
      this.jdField_c_of_type_Boolean = false;
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramxmt.b.setVisibility(0);
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramxhf = this.jdField_a_of_type_Wlh.b;
      if (TextUtils.isEmpty(paramxhf)) {
        break label502;
      }
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(paramxhf);
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramxhf);
      paramxmt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846440);
      if ((localObject != null) && (!TextUtils.isEmpty(((wle)localObject).jdField_c_of_type_JavaLangString))) {
        xmp.a(((wle)localObject).jdField_c_of_type_JavaLangString, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidViewView.getContext().getResources().getDrawable(2130846440), paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
      }
      paramxmt = ((wke)wjs.a(2)).b(localStoryVideoItem.mOwnerUid);
      if (this.jdField_c_of_type_Boolean)
      {
        if ((paramxmt == null) || (!paramxmt.isVip)) {
          break label531;
        }
        i = 1;
        if (localObject == null) {
          break label536;
        }
        j = ((wle)localObject).jdField_a_of_type_Int;
        label355:
        if (i == 0) {
          break label542;
        }
        paramxmt = "2";
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
    for (paramxhf = ((wle)localObject).b;; paramxhf = "")
    {
      ykv.a("play_video", "multishoot_entry_exp", 0, j, new String[] { paramxmt, paramxhf, "", localStoryVideoItem.mVid });
      return;
      if ((localwlh != null) && (localwlh.jdField_a_of_type_Int == 3))
      {
        this.jdField_a_of_type_Int = 2;
        this.jdField_a_of_type_Wlh = localwlh;
        ykq.a("CaptureTogetherBannerVideoInfoController", "get video link info from extern, vid:%s, title:%s", paramxhf.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wlh.b);
        break;
      }
      ykq.a("CaptureTogetherBannerVideoInfoController", "VideoLinkInfo error, hide widget, vid:%s", paramxhf.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Xmp.k();
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Wlh = null;
      return;
      label486:
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = paramxhf.jdField_a_of_type_JavaLangString;
      break label192;
      label502:
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131700939));
      paramxmt.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131700940));
      break label247;
      i = 0;
      break label343;
      j = 0;
      break label355;
      paramxmt = "1";
      break label362;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnp
 * JD-Core Version:    0.7.0.1
 */