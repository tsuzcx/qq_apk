import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleFeedPlayerHelper.1;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleFeedCleanPlayView;
import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class tqc
  extends RecyclerView.OnScrollListener
{
  private static float jdField_a_of_type_Float;
  private static int jdField_a_of_type_Int = -1;
  private static boolean jdField_a_of_type_Boolean = true;
  private static float jdField_b_of_type_Float;
  private static int jdField_b_of_type_Int;
  private static int jdField_c_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ReportExtraTypeInfo jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QCircleFeedPlayerHelper.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<RecyclerView.ViewHolder> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e = jdField_a_of_type_Int;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_Float = 200.0F;
    jdField_b_of_type_Float = 3.0F;
  }
  
  public tqc(Context paramContext, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  private RecyclerView.ViewHolder a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if (paramString.equals(a(a(localViewHolder)))) {
        return localViewHolder;
      }
    }
    return null;
  }
  
  private FrameLayout a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof QCircleFeedWidget)) && (((QCircleFeedWidget)paramViewHolder.itemView).a() != null)) {
      return ((QCircleFeedWidget)paramViewHolder.itemView).a().jdField_a_of_type_AndroidWidgetFrameLayout;
    }
    return null;
  }
  
  private ReportExtraTypeInfo a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString.itemView instanceof QCircleFeedWidget)))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)((QCircleFeedWidget)paramString.itemView).a());
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = ((QCircleFeedWidget)paramString.itemView).b();
    }
    return this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo;
  }
  
  private QCircleFeedCleanPlayView a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && ((paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))) {
      return (QCircleFeedCleanPlayView)paramFrameLayout.getChildAt(0);
    }
    return null;
  }
  
  private QCircleFeedCleanPlayView a(String paramString)
  {
    return a(a(a(paramString)));
  }
  
  private FeedCloudMeta.StFeed a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed))) {
      return (FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).a();
    }
    return null;
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (paramStFeed.isRecomFd.get()) {
        return paramStFeed.recomForward.id.get();
      }
      return paramStFeed.id.get();
    }
    return null;
  }
  
  private udu a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder != null) && ((paramViewHolder.itemView instanceof QCircleFeedWidget)) && (((QCircleFeedWidget)paramViewHolder.itemView).a() != null)) {
      return ((QCircleFeedWidget)paramViewHolder.itemView).a();
    }
    return null;
  }
  
  private void a(FrameLayout paramFrameLayout, String paramString, RecyclerView.ViewHolder paramViewHolder)
  {
    if (paramFrameLayout != null) {
      while ((paramFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))
      {
        View localView = paramFrameLayout.getChildAt(0);
        paramFrameLayout.removeView(localView);
        if (((QCircleFeedCleanPlayView)localView).d())
        {
          ((QCircleFeedCleanPlayView)localView).b();
          tyg.a(8, 5, a(paramString));
        }
        QLog.d("QCircleFeedPlayerHelper", 4, new Object[] { "clean player", paramString });
        ((QCircleFeedCleanPlayView)localView).a();
        a(a(paramViewHolder), true);
      }
    }
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      if (!jdField_a_of_type_Boolean) {
        break label19;
      }
    }
    label19:
    for (int i = 2130843568;; i = 2130843569)
    {
      paramImageView.setImageResource(i);
      return;
    }
  }
  
  private void a(String paramString)
  {
    RecyclerView.ViewHolder localViewHolder = a(paramString);
    FrameLayout localFrameLayout = a(localViewHolder);
    if (localFrameLayout != null) {
      while ((localFrameLayout.getChildAt(0) instanceof QCircleFeedCleanPlayView))
      {
        View localView = localFrameLayout.getChildAt(0);
        localFrameLayout.removeView(localView);
        if (((QCircleFeedCleanPlayView)localView).d())
        {
          ((QCircleFeedCleanPlayView)localView).b();
          tyg.a(8, 5, a(paramString));
        }
        ((QCircleFeedCleanPlayView)localView).a();
        a(a(localViewHolder), true);
      }
    }
  }
  
  private void a(udu paramudu, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      if (!ndk.a(BaseApplicationImpl.context))
      {
        bfhq.a().a(alpo.a(2131715032));
        QLog.d("QCircleFeedPlayerHelper", 4, "network not available");
        return;
      }
      String str2 = a(paramString1, "vid");
      FrameLayout localFrameLayout = paramudu.jdField_a_of_type_AndroidWidgetFrameLayout;
      FeedCloudMeta.StFeed localStFeed = paramudu.a();
      if ((!TextUtils.isEmpty(paramString1)) && (localFrameLayout != null) && (localStFeed != null))
      {
        a(localFrameLayout, paramString2, a(paramString2));
        QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = new QCircleFeedCleanPlayView(this.jdField_a_of_type_AndroidContentContext, paramudu.a());
        localQCircleFeedCleanPlayView.setVideoCover(paramudu.jdField_a_of_type_ComTencentImageURLImageView);
        localQCircleFeedCleanPlayView.setLoopBack(true);
        localQCircleFeedCleanPlayView.setOutPutMute(jdField_a_of_type_Boolean);
        localQCircleFeedCleanPlayView.setData(localStFeed);
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = localStFeed.video.fileId.get();
        }
        localQCircleFeedCleanPlayView.setVideoPath(str1, "", paramString1, localStFeed.video.fileSize.get(), localStFeed.video.duration.get(), 0);
        localQCircleFeedCleanPlayView.setOnProgressListener(new tqd(this, paramString1));
        localQCircleFeedCleanPlayView.setOnPreparedListener(new tqe(this, paramString1, localQCircleFeedCleanPlayView, paramString2));
        localQCircleFeedCleanPlayView.setDarkFrameCheckListener(new tqf(this, paramudu));
        localFrameLayout.addView(localQCircleFeedCleanPlayView, 0, new FrameLayout.LayoutParams(-1, -1));
        this.jdField_a_of_type_JavaLangString = paramString2;
        a(paramudu.b);
        i();
        QLog.d("QCircleFeedPlayerHelper", 4, "playInner mCurrentPlayerUrl: " + this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.d("QCircleFeedPlayerHelper", 4, "vid is empty");
      return;
    }
    QLog.d("QCircleFeedPlayerHelper", 4, "url is empty");
  }
  
  private void a(udu paramudu, boolean paramBoolean)
  {
    if (paramudu != null)
    {
      if (!paramBoolean) {
        break label56;
      }
      if (ndk.a(BaseApplicationImpl.context) == 1) {
        break label44;
      }
      paramudu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramudu.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramudu.b.setVisibility(8);
      return;
      label44:
      paramudu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label56:
    paramudu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramudu.b.setVisibility(0);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
        this.jdField_c_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType != 9);
  }
  
  private boolean a(RecyclerView.ViewHolder paramViewHolder)
  {
    return (paramViewHolder != null) && ((paramViewHolder.itemView instanceof BaseWidgetView)) && ((((BaseWidgetView)paramViewHolder.itemView).a() instanceof FeedCloudMeta.StFeed)) && (((FeedCloudMeta.StFeed)((BaseWidgetView)paramViewHolder.itemView).a()).type.get() == 3);
  }
  
  private boolean a(View paramView)
  {
    if (ndk.a(BaseApplicationImpl.context) != 1)
    {
      QLog.d("QCircleFeedPlayerHelper", 4, "not wifi autoPlay return");
      return true;
    }
    if ((paramView instanceof QCircleFeedWidget))
    {
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)((QCircleFeedWidget)paramView).a();
      if (localStFeed.type.get() == 3)
      {
        Object localObject = ((QCircleFeedWidget)paramView).a().jdField_a_of_type_AndroidWidgetFrameLayout;
        if (b((View)localObject))
        {
          localObject = ((FrameLayout)localObject).getChildAt(0);
          if ((localObject instanceof QCircleFeedCleanPlayView))
          {
            localObject = (QCircleFeedCleanPlayView)localObject;
            if (!((QCircleFeedCleanPlayView)localObject).d())
            {
              if (!this.jdField_a_of_type_JavaLangString.equals(a(localStFeed))) {
                break label156;
              }
              ((QCircleFeedCleanPlayView)localObject).setIsAutoPlay(true);
              ((QCircleFeedCleanPlayView)localObject).c();
              ((QCircleFeedCleanPlayView)localObject).setOutPutMute(jdField_a_of_type_Boolean);
              a(((QCircleFeedWidget)paramView).a(), false);
              tyg.a(8, 4, a(localStFeed.id.get()));
            }
          }
          for (;;)
          {
            return true;
            label156:
            a(((QCircleFeedWidget)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
            continue;
            a(((QCircleFeedWidget)paramView).a(), localStFeed.video.playUrl.get(), a(localStFeed));
          }
        }
      }
    }
    return false;
  }
  
  private boolean b(View paramView)
  {
    Rect localRect;
    int j;
    if (paramView != null)
    {
      localRect = new Rect(0, 0, ImmersiveUtils.a(), ImmersiveUtils.b());
      paramView.getGlobalVisibleRect(localRect);
      j = paramView.getHeight();
      if (localRect.bottom <= 0) {
        break label141;
      }
      if (localRect.bottom > azgq.jdField_b_of_type_Int) {
        localRect.bottom = azgq.jdField_b_of_type_Int;
      }
    }
    label141:
    for (int i = localRect.bottom - localRect.top;; i = 0)
    {
      float f1 = i / j;
      QLog.d("QCircleFeedPlayerHelper", 4, f1 + "  " + localRect.bottom + "  " + localRect.top);
      return f1 >= 0.5D;
    }
  }
  
  public static void e()
  {
    jdField_a_of_type_Boolean = true;
  }
  
  private void f()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.jdField_a_of_type_JavaLangString);
    if ((localQCircleFeedCleanPlayView != null) && (!b(localQCircleFeedCleanPlayView)))
    {
      if (localQCircleFeedCleanPlayView.d())
      {
        localQCircleFeedCleanPlayView.b();
        tyg.a(8, 5, a(this.jdField_a_of_type_JavaLangString));
      }
      a(a(a(this.jdField_a_of_type_JavaLangString)), true);
    }
  }
  
  private void g()
  {
    this.e = jdField_a_of_type_Int;
    this.f = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void h()
  {
    try
    {
      yee localyee;
      Object localObject;
      int i;
      int j;
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null) && ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager() instanceof yee)))
      {
        localyee = (yee)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutManager();
        localObject = localyee.findFirstVisibleItemPositions(null);
        int[] arrayOfInt = localyee.findLastVisibleItemPositions(null);
        i = localObject[0];
        j = arrayOfInt[0];
        QLog.d("QCircleFeedPlayerHelper", 4, i + "  " + j);
        if (i <= j) {
          QLog.d("QCircleFeedPlayerHelper", 4, "misScrollUp:" + this.jdField_b_of_type_Boolean);
        }
      }
      for (;;)
      {
        if (i <= j)
        {
          localObject = localyee.findViewByPosition(i);
          if ((localObject != null) && (a((View)localObject))) {
            this.g = i;
          }
        }
        else
        {
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    RecyclerView.ViewHolder localViewHolder1 = a(this.jdField_a_of_type_JavaLangString);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.ViewHolder localViewHolder2 = (RecyclerView.ViewHolder)localIterator.next();
      if (localViewHolder2 != localViewHolder1)
      {
        FeedCloudMeta.StFeed localStFeed = a(localViewHolder2);
        if ((localStFeed != null) && (!this.jdField_a_of_type_JavaLangString.equals(a(localStFeed)))) {
          a(a(localViewHolder2), a(localStFeed), localViewHolder2);
        }
      }
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public long a()
  {
    QCircleFeedCleanPlayView localQCircleFeedCleanPlayView = a(this.jdField_a_of_type_JavaLangString);
    if ((localQCircleFeedCleanPlayView != null) && (localQCircleFeedCleanPlayView.a() != null)) {
      return localQCircleFeedCleanPlayView.a().a();
    }
    return 0L;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = "";
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("&");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString1 = str;
      if (i < j)
      {
        paramString1 = arrayOfString[i];
        if (paramString1.contains(paramString2)) {
          paramString1 = paramString1.replace(paramString2 + "=", "");
        }
      }
      else
      {
        return paramString1;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    i();
    g();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    b();
    if (!a()) {
      a(true);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      if (localStFeed != null)
      {
        a(a(localStFeed));
        if (this.jdField_a_of_type_JavaLangString.equals(a(localStFeed))) {
          this.jdField_a_of_type_JavaLangString = "";
        }
        QLog.d("QCircleFeedPlayerHelper", 4, "unbind view position:" + paramViewHolder.getAdapterPosition());
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, FeedCloudMeta.StFeed paramStFeed)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).a(this);
      }
      if (paramStFeed != null)
      {
        paramStFeed = a(paramStFeed);
        if (a(this.jdField_a_of_type_JavaLangString) != paramViewHolder) {
          break label95;
        }
        paramStFeed = a(a(paramViewHolder));
        if ((paramStFeed != null) && (paramStFeed.d()))
        {
          if (paramStFeed.a() != null) {
            paramStFeed.a().setVisibility(8);
          }
          a(a(paramViewHolder), false);
        }
      }
    }
    return;
    label95:
    this.jdField_a_of_type_JavaUtilSet.add(paramViewHolder);
    a(a(paramViewHolder), paramStFeed, paramViewHolder);
    QLog.d("QCircleFeedPlayerHelper", 4, "onDataBind" + paramViewHolder.getAdapterPosition());
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, ImageView paramImageView, int paramInt)
  {
    Object localObject;
    boolean bool;
    label66:
    ArrayList localArrayList;
    if (paramStFeed != null)
    {
      localObject = a(a(paramStFeed));
      if (localObject != null)
      {
        if (((QCircleFeedCleanPlayView)localObject).b()) {
          break label183;
        }
        bool = true;
        jdField_a_of_type_Boolean = bool;
        ((QCircleFeedCleanPlayView)localObject).setOutPutMute(jdField_a_of_type_Boolean);
        localObject = paramStFeed.poster.id.get();
        if (!jdField_a_of_type_Boolean) {
          break label189;
        }
        i = 9;
        tyg.a((String)localObject, 8, i, paramInt, paramStFeed, null);
        localArrayList = new ArrayList();
        localArrayList.add(tym.a("ext2", paramStFeed.recomInfo.recomReason.get()));
        if (!tym.a().c(1)) {
          break label196;
        }
        localObject = "1";
        label126:
        localArrayList.add(tym.a("ext4", (String)localObject));
        localObject = paramStFeed.poster.id.get();
        if (!jdField_a_of_type_Boolean) {
          break label204;
        }
      }
    }
    label183:
    label189:
    label196:
    label204:
    for (int i = 9;; i = 8)
    {
      tyg.a((String)localObject, 8, i, paramInt, paramStFeed, localArrayList);
      a(paramImageView);
      return;
      bool = false;
      break;
      i = 8;
      break label66;
      localObject = "2";
      break label126;
    }
  }
  
  public void a(udu paramudu, FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      String str = paramStFeed.video.playUrl.get();
      if (!TextUtils.isEmpty(str)) {
        a(paramudu, str, a(paramStFeed));
      }
    }
  }
  
  public void b()
  {
    if (this.d == -1) {}
    RecyclerView.ViewHolder localViewHolder;
    Object localObject;
    do
    {
      do
      {
        return;
        localViewHolder = a(this.jdField_a_of_type_JavaLangString);
        localObject = a(localViewHolder);
      } while ((localObject == null) || (!(((FrameLayout)localObject).getChildAt(0) instanceof QCircleFeedCleanPlayView)) || (!b(((FrameLayout)localObject).getChildAt(0))));
      localObject = ((FrameLayout)localObject).getChildAt(0);
    } while ((((QCircleFeedCleanPlayView)localObject).d()) || (a(localViewHolder) == null));
    ((QCircleFeedCleanPlayView)localObject).c();
    ((QCircleFeedCleanPlayView)localObject).setOutPutMute(jdField_a_of_type_Boolean);
    a(a(localViewHolder).b);
    tyg.a(8, 4, a(this.jdField_a_of_type_JavaLangString));
    QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (a(paramViewHolder))
    {
      if (a(paramViewHolder) != null) {
        a(paramViewHolder).a(this);
      }
      FeedCloudMeta.StFeed localStFeed = a(paramViewHolder);
      this.jdField_a_of_type_JavaUtilSet.add(paramViewHolder);
      a(a(paramViewHolder), a(localStFeed), paramViewHolder);
      QLog.d("QCircleFeedPlayerHelper", 4, "bind position:" + paramViewHolder.getAdapterPosition());
      if (a()) {
        a(true);
      }
    }
  }
  
  public void c()
  {
    a(false);
    RecyclerView.ViewHolder localViewHolder = a(this.jdField_a_of_type_JavaLangString);
    Object localObject = a(localViewHolder);
    if (localObject != null)
    {
      localObject = ((FrameLayout)localObject).getChildAt(0);
      if (((localObject instanceof QCircleFeedCleanPlayView)) && (((QCircleFeedCleanPlayView)localObject).d()))
      {
        ((QCircleFeedCleanPlayView)localObject).b();
        tyg.a(8, 5, a(this.jdField_a_of_type_JavaLangString));
        QLog.d("QCircleFeedPlayerHelper", 4, "onResume play video position:" + localViewHolder.getAdapterPosition());
      }
    }
  }
  
  public void d()
  {
    this.d = -1;
    c();
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      g();
      h();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    if (paramInt2 >= 0)
    {
      this.jdField_b_of_type_Boolean = true;
      if ((this.e != jdField_b_of_type_Int) && (this.e != jdField_a_of_type_Int))
      {
        g();
        QLog.d("QCircleFeedPlayerHelper", 4, "change orient to up:" + this.e);
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.f += paramInt2;
    }
    for (this.e = jdField_b_of_type_Int;; this.e = jdField_c_of_type_Int)
    {
      float f1 = (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      if (f1 > jdField_a_of_type_Float)
      {
        g();
        if (Math.abs(this.f / f1) < jdField_b_of_type_Float) {
          h();
        }
      }
      f();
      return;
      if ((this.e != jdField_c_of_type_Int) && (this.e != jdField_a_of_type_Int))
      {
        g();
        QLog.d("QCircleFeedPlayerHelper", 4, "change orient to down:" + this.e);
      }
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      this.f += paramInt2;
      this.jdField_b_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tqc
 * JD-Core Version:    0.7.0.1
 */