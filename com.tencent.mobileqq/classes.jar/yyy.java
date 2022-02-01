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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class yyy
  extends yxr
  implements View.OnClickListener, bljm, yzd, zlh
{
  private int jdField_a_of_type_Int;
  private SparseArray<zle> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQStoryPullToRefreshListView jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QQStoryContext.a().a().createEntityManager();
  private List<zlk> jdField_a_of_type_JavaUtilList;
  private yzc jdField_a_of_type_Yzc;
  private zli jdField_a_of_type_Zli;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View e;
  private View f;
  
  public yyy(@NonNull yxt paramyxt)
  {
    super(paramyxt);
  }
  
  private yzb a()
  {
    yzb localyzb = new yzb();
    yvm localyvm = (yvm)a(yvm.class);
    if (localyvm != null) {
      localyvm.a(localyzb);
    }
    return localyzb;
  }
  
  @Nonnull
  private zle a(int paramInt)
  {
    Object localObject2 = (zle)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new zle(this, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
      ((zle)localObject1).a();
      if (this.jdField_a_of_type_Yzc != null)
      {
        localObject2 = new zlk(new zll(this.jdField_a_of_type_Yzc.jdField_a_of_type_Long, this.jdField_a_of_type_Yzc.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Yzc.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Yzc.jdField_a_of_type_Int), this.jdField_a_of_type_Yzc.jdField_b_of_type_Int, this.jdField_a_of_type_Yzc.c);
        ((zle)localObject1).a().add(localObject2);
        ((zle)localObject1).a((zlk)localObject2);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(List<zlk> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((zlk)paramList.next()).a.jdField_a_of_type_Int == 1) {
        paramList.remove();
      }
    }
  }
  
  private void a(@Nullable zlk paramzlk, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramzlk == null)
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
      return;
    }
    this.e.setVisibility(8);
    this.f.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramzlk.a.jdField_a_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    zlk localzlk = a(paramInt).a();
    if (localzlk == null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131702615));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localzlk.a.jdField_a_of_type_JavaLangString);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378421));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369042));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369050));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366048);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376603);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370331);
      this.e = this.jdField_a_of_type_AndroidViewView.findViewById(2131368043);
      this.f = this.jdField_a_of_type_AndroidViewView.findViewById(2131364530);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364529));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365378));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_Zli = new zli(a());
      g();
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Zli);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new yyz(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new yza(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void g()
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
    zlk localzlk = this.jdField_a_of_type_Zli.a();
    int i;
    if ((localObject == null) && (localzlk != null))
    {
      i = 1;
      if (this.jdField_b_of_type_Int != 1) {
        break label121;
      }
    }
    label121:
    for (localObject = "1";; localObject = "2")
    {
      yup.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.jdField_a_of_type_Int).a(localzlk);
      this.jdField_a_of_type_Yxt.a(0);
      return;
      if ((localObject != null) && (localzlk != null) && (!((zlk)localObject).equals(localzlk)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localzlk == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  public zlk a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Yxt.d()))
    {
      yuk.e("Q.qqstory.detail.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Yxt.d()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362193));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378384));
    String str1 = this.jdField_a_of_type_Yxt.a.a("video_tag_info");
    if (str1 != null) {}
    try
    {
      this.jdField_a_of_type_Yzc = ((yzc)JsonORM.a(new JSONObject(str1), yzc.class));
      b(this.jdField_a_of_type_Int);
      a(yzd.class, this);
      this.jdField_b_of_type_Int = ((Integer)((wta)wth.a(10)).b("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
      if (this.jdField_b_of_type_Int == 1)
      {
        str1 = "1";
        yup.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.jdField_a_of_type_JavaUtilList = zle.a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
        a(this.jdField_a_of_type_JavaUtilList);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        yuk.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        yuk.b("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void a(int paramInt)
  {
    zle localzle = (zle)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localzle == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localzle.a().remove(localzle.a());
    localzle.a(null);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    yuk.b("Q.qqstory.detail.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      c(8);
      return;
    case 28: 
      f();
      paramObject = a(this.jdField_a_of_type_Int);
      yzb localyzb = a();
      if ((paramObject.a() != null) && (!paramObject.a().isEmpty()))
      {
        l();
        if (!paramObject.a(localyzb)) {
          if (paramObject.a() != null) {
            this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.a().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Zli.a(paramObject.a());
          this.jdField_a_of_type_Zli.a(paramObject.a());
          this.jdField_a_of_type_Zli.notifyDataSetChanged();
          a(paramObject.a(), false);
          c(0);
          return;
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.a(localyzb);
        }
      }
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        paramObject.a(this.jdField_a_of_type_JavaUtilList);
        l();
      }
      for (;;)
      {
        paramObject.a(localyzb);
        break;
        k();
      }
    }
    b(this.jdField_a_of_type_Int);
    c(8);
  }
  
  public void a(int paramInt, @Nonnull List<zlk> paramList, boolean paramBoolean)
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
    zlk localzlk = this.jdField_a_of_type_Zli.a();
    localObject = localzlk;
    if (!paramList.contains(localzlk)) {
      localObject = null;
    }
    a((zlk)localObject, false);
    this.jdField_a_of_type_Zli.a((zlk)localObject);
    this.jdField_a_of_type_Zli.a(paramList);
    this.jdField_a_of_type_Zli.notifyDataSetChanged();
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
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    yuk.a("Q.qqstory.detail.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    zlk localzlk = a(paramInt).a();
    if (localzlk == null)
    {
      yuk.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    yuk.a("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has tag, tag=", Integer.valueOf(paramInt), localzlk.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localzlk.a.jdField_a_of_type_Long);
    localTagInfoBase.tag_type.set(localzlk.a.jdField_a_of_type_Int);
    localTagInfoBase.tag_name.set(localzlk.a.jdField_a_of_type_JavaLangString);
    localTagInfoBase.tag_desc.set(localzlk.a.jdField_b_of_type_JavaLangString);
    paramzih.a.tagInfoBytes = localTagInfoBase.toByteArray();
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
        this.jdField_a_of_type_Zli.a(null);
        this.jdField_a_of_type_Yxt.a(0);
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
      this.jdField_a_of_type_Int = this.jdField_a_of_type_Yxt.a();
      b(this.jdField_a_of_type_Int);
    }
  }
  
  public void b(int paramInt, @Nonnull List<zlk> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    zlk localzlk;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        i();
        return;
      }
      l();
      localzlk = this.jdField_a_of_type_Zli.a();
      if (paramList.contains(localzlk)) {
        break label102;
      }
    }
    for (;;)
    {
      a((zlk)localObject, false);
      this.jdField_a_of_type_Zli.a((zlk)localObject);
      this.jdField_a_of_type_Zli.a(paramList);
      this.jdField_a_of_type_Zli.notifyDataSetChanged();
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
      localObject = localzlk;
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
      this.jdField_a_of_type_Zli.a(null);
      this.jdField_a_of_type_Yxt.a(0);
      continue;
      m();
      continue;
      k();
      yzb localyzb = a();
      a(this.jdField_a_of_type_Int).a(localyzb);
      continue;
      this.jdField_a_of_type_Zli.a(null);
      this.jdField_a_of_type_Zli.notifyDataSetChanged();
      a(null, false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.jdField_a_of_type_Int).a();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (zlk)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Zli.a(paramAdapterView);
      this.jdField_a_of_type_Zli.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.jdField_b_of_type_Int != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      yup.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyy
 * JD-Core Version:    0.7.0.1
 */