import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ypa
  extends ynu
  implements View.OnClickListener, AdapterView.OnItemClickListener, ypf, zba
{
  private int jdField_a_of_type_Int;
  private SparseArray<zax> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QQStoryContext.a().a().createEntityManager();
  private List<zbd> jdField_a_of_type_JavaUtilList;
  private ype jdField_a_of_type_Ype;
  private zbb jdField_a_of_type_Zbb;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public ypa(@NonNull ynw paramynw)
  {
    super(paramynw);
  }
  
  private ypd a()
  {
    ypd localypd = new ypd();
    ylq localylq = (ylq)a(ylq.class);
    if (localylq != null) {
      localylq.a(localypd);
    }
    return localypd;
  }
  
  @Nonnull
  private zax a(int paramInt)
  {
    Object localObject2 = (zax)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new zax(this, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      ((zax)localObject1).a();
      if (this.jdField_a_of_type_Ype != null)
      {
        localObject2 = new zbd(new zbe(this.jdField_a_of_type_Ype.jdField_a_of_type_Long, this.jdField_a_of_type_Ype.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ype.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Ype.jdField_a_of_type_Int), this.jdField_a_of_type_Ype.jdField_b_of_type_Int, this.jdField_a_of_type_Ype.c);
        ((zax)localObject1).a().add(localObject2);
        ((zax)localObject1).a((zbd)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<zbd> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((zbd)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable zbd paramzbd, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramzbd == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramzbd.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    zbd localzbd = a(paramInt).a();
    if (localzbd == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131703201));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localzbd.a.jdField_a_of_type_JavaLangString);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378476));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369231));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369239));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366179);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376624);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370478);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131368213);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364632);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364631));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365503));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Zbb = new zbb(a());
      h();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Zbb);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new ypb(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new ypc(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.b.setHeaderBgColor(0);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void j()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void k()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void m()
  {
    Object localObject = a(this.jdField_a_of_type_Int).a();
    zbd localzbd = this.jdField_a_of_type_Zbb.a();
    int i;
    if ((localObject == null) && (localzbd != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label121;
      }
    }
    label121:
    for (localObject = "1";; localObject = "2")
    {
      ykv.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localzbd);
      this.jdField_a_of_type_Ynw.a(0);
      return;
      if ((localObject != null) && (localzbd != null) && (!((zbd)localObject).equals(localzbd)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localzbd == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public zbd a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Ynw.d()))
    {
      ykq.e("Q.qqstory.detail.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Ynw.d()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362196));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378439));
    String str1 = this.jdField_a_of_type_Ynw.a.getStringExtra("video_tag_info");
    if (str1 != null) {}
    try
    {
      this.jdField_a_of_type_Ype = ((ype)JsonORM.a(new JSONObject(str1), ype.class));
      b(this.jdField_a_of_type_Int);
      a(ypf.class, this);
      this.jdField_b_of_type_Int = ((Integer)((wjl)wjs.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
      if (this.jdField_b_of_type_Int == 1)
      {
        str1 = "1";
        ykv.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = zax.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        ykq.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ykq.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    zax localzax = (zax)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localzax == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localzax.a().remove(localzax.a());
    localzax.a(null);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    ykq.b("Q.qqstory.detail.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 28: 
      g();
      paramObject = a(this.jdField_a_of_type_Int);
      ypd localypd = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        l();
        if (!paramObject.a(localypd)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Zbb.a(paramObject.a());
          this.jdField_a_of_type_Zbb.a(paramObject.a());
          this.jdField_a_of_type_Zbb.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localypd);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        l();
      }
      for (;;)
      {
        paramObject.a(localypd);
        break;
        k();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @Nonnull List<zbd> paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
    if (paramInt == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((QQStoryPullToRefreshListView)localObject).a(paramBoolean);
      if (paramInt != 0) {
        break label104;
      }
      if (!paramList.isEmpty()) {
        break;
      }
      i();
      return;
    }
    l();
    zbd localzbd = this.jdField_a_of_type_Zbb.a();
    localObject = localzbd;
    if (!paramList.contains(localzbd)) {
      localObject = null;
    }
    a((zbd)localObject, false);
    this.jdField_a_of_type_Zbb.a((zbd)localObject);
    this.jdField_a_of_type_Zbb.a(paramList);
    this.jdField_a_of_type_Zbb.notifyDataSetChanged();
    return;
    label104:
    if (paramList.isEmpty())
    {
      j();
      a(null, true);
      return;
    }
    l();
  }
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    ykq.a("Q.qqstory.detail.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    zbd localzbd = a(paramInt).a();
    if (localzbd == null)
    {
      ykq.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    ykq.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has tag, tag=", Integer.valueOf(paramInt), localzbd.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localzbd.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localzbd.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localzbd.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localzbd.a.jdField_b_of_type_JavaLangString);
    paramyya.a.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_a_of_type_Zbb.a(null);
        this.jdField_a_of_type_Ynw.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Ynw.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<zbd> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    zbd localzbd;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        i();
        return;
      }
      l();
      localzbd = this.jdField_a_of_type_Zbb.a();
      if (paramList.contains(localzbd)) {
        break label102;
      }
    }
    for (;;)
    {
      a((zbd)localObject, false);
      this.jdField_a_of_type_Zbb.a((zbd)localObject);
      this.jdField_a_of_type_Zbb.a(paramList);
      this.jdField_a_of_type_Zbb.notifyDataSetChanged();
      return;
      if (paramList.isEmpty())
      {
        j();
        a(null, true);
        return;
      }
      l();
      return;
      label102:
      localObject = localzbd;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Zbb.a(null);
      this.jdField_a_of_type_Ynw.a(0);
      continue;
      m();
      continue;
      k();
      ypd localypd = a();
      a(this.jdField_a_of_type_Int).a(localypd);
      continue;
      this.jdField_a_of_type_Zbb.a(null);
      this.jdField_a_of_type_Zbb.notifyDataSetChanged();
      a(null, false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (zbd)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Zbb.a(paramAdapterView);
      this.jdField_a_of_type_Zbb.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      ykv.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypa
 * JD-Core Version:    0.7.0.1
 */