import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DatalineSessionAdapter.1;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.XPanelContainer;

public class db
  extends du
{
  private DataLineMsgSetList a;
  private boolean aQ = true;
  protected QQAppInterface app;
  protected LiteActivity b;
  private Drawable d;
  private int dI;
  private int dJ;
  private int dK = -1;
  private Drawable f;
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected View.OnClickListener mOnClickListener = new dc(this);
  
  public db(Context paramContext, DataLineMsgSetList paramDataLineMsgSetList, LiteActivity paramLiteActivity, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.a = paramDataLineMsgSetList;
    this.b = paramLiteActivity;
    this.app = paramQQAppInterface;
    this.dK = this.a.size();
    this.mInflater = LayoutInflater.from(this.mContext);
    this.dI = this.mContext.getResources().getDimensionPixelSize(2131297045);
    this.dJ = this.mContext.getResources().getDimensionPixelSize(2131297044);
    cj();
  }
  
  private Drawable a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    boolean bool = paramDataLineMsgRecord.isSendFromLocal();
    int i;
    if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009))
    {
      i = 1;
      if (i != 0) {
        break label40;
      }
      paramDataLineMsgRecord = null;
    }
    for (;;)
    {
      return paramDataLineMsgRecord;
      i = 0;
      break;
      label40:
      Drawable localDrawable;
      if ((this.f == null) || (this.d == null))
      {
        paramDataLineMsgRecord = this.app.getApp().getResources();
        localDrawable = paramDataLineMsgRecord.getDrawable(2130851006);
        paramDataLineMsgRecord = paramDataLineMsgRecord.getDrawable(2130850829);
        this.d = localDrawable;
        this.f = paramDataLineMsgRecord;
      }
      while (bool)
      {
        return localDrawable;
        localDrawable = this.d;
        paramDataLineMsgRecord = this.f;
      }
    }
  }
  
  private void a(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (paramDrawable == null)
    {
      paramView.setBackgroundDrawable(null);
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  private void a(GridView paramGridView)
  {
    int i = (this.b.getWindowManager().getDefaultDisplay().getWidth() - wja.dp2px(147.0F, this.b.getResources()) - 2) / 3;
    paramGridView.setNumColumns(3);
    paramGridView.setColumnWidth(i);
    paramGridView.setHorizontalSpacing(1);
    paramGridView.setSelector(new ColorDrawable(0));
    paramGridView.setTag(Integer.valueOf(i));
    paramGridView.setClickable(true);
    paramGridView.setLongClickable(true);
    paramGridView.setAddStatesFromChildren(true);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, RelativeLayout paramRelativeLayout, dl paramdl)
  {
    Object localObject;
    if ((paramDataLineMsgRecord.vipBubbleID == 100000L) && (paramDataLineMsgRecord.msgtype == -1000))
    {
      localObject = ifw.Q(this.mContext.getApplicationContext());
      localObject = ifs.a(this.mContext.getApplicationContext()).a(paramDataLineMsgRecord.msg, paramDataLineMsgRecord.msgId, (String)localObject);
      if ((localObject != null) && (((ifr)localObject).e().booleanValue()) && (!paramDataLineMsgRecord.isSendFromLocal()))
      {
        paramdl.a = adyd.a(100001, this.app, this.mContext.getResources(), this);
        if (paramdl.a != null)
        {
          paramdl.a.m(paramRelativeLayout, null);
          if (paramDataLineMsgRecord.msgtype == -1000) {
            break label333;
          }
        }
      }
    }
    label333:
    for (boolean bool = true;; bool = false)
    {
      int i = paramDataLineMsgRecord.vipBubbleDiyTextId;
      if (i <= 0) {
        acle.R(paramDataLineMsgRecord.vipBubbleID);
      }
      paramdl.a.a(this.app, paramDataLineMsgRecord.isSendFromLocal(), true, bool, paramRelativeLayout, ku.a(paramDataLineMsgRecord), i);
      if ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2009))
      {
        localObject = a(paramDataLineMsgRecord);
        if (localObject != null) {
          a(paramRelativeLayout, (Drawable)localObject);
        }
      }
      if (paramDataLineMsgRecord.msgtype == -2000) {
        a(paramRelativeLayout, null);
      }
      if (paramDataLineMsgRecord.msgtype == -1000) {
        a(paramdl, paramRelativeLayout, paramDataLineMsgRecord, paramdl.a);
      }
      a(paramRelativeLayout, paramDataLineMsgRecord);
      return;
      paramdl.a = adyd.a(100000, this.app, this.mContext.getResources(), this);
      break;
      paramdl.a = adyd.a(((acle)this.app.getBusinessHandler(13)).j(paramDataLineMsgRecord), this.app, this.mContext.getResources(), this);
      break;
    }
  }
  
  private void a(dl paramdl, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), 2130838161), paramInt1, paramInt2, false);
        Object localObject1 = aqhu.c(localBitmap, wja.dp2px(12.0F, this.b.getResources()));
        localObject3 = localObject1;
        if (localBitmap != null) {}
        localObject3 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          localBitmap.recycle();
          localObject3 = localObject1;
          if (localObject3 == null) {
            break;
          }
          localObject1 = new ClipDrawable(new BitmapDrawable(localObject3), 48, 2);
          paramdl.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Object localObject3;
          Object localObject2;
          break label104;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        localObject2 = null;
      }
      label104:
      if (QLog.isColorLevel())
      {
        QLog.e("DatalineSessionAdapter", 2, "DataLineSessionAdapter OOM");
        localObject3 = localObject2;
      }
    }
    paramdl.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable(null);
  }
  
  private boolean a(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    do
    {
      return true;
      if (paramdl.a().g == null) {
        return false;
      }
    } while (paramDataLineMsgSet == null);
    int i = paramDataLineMsgSet.getCompletedCount();
    int j = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    if ((paramDataLineMsgSet.getAt(0) != null) && (paramDataLineMsgSet.getAt(0).strMoloIconUrl != null))
    {
      paramdl.a().d.setAsyncImage(paramDataLineMsgSet.getAt(0).strMoloIconUrl);
      if ((paramDataLineMsgSet.getTotalCount() < 2) || (paramDataLineMsgSet.getAt(1) == null) || (paramDataLineMsgSet.getAt(1).strMoloIconUrl == null)) {
        break label492;
      }
      paramdl.a().e.setAsyncImage(paramDataLineMsgSet.getAt(1).strMoloIconUrl);
      label128:
      if ((paramDataLineMsgSet.getTotalCount() < 3) || (paramDataLineMsgSet.getAt(2) == null) || (paramDataLineMsgSet.getAt(2).strMoloIconUrl == null)) {
        break label508;
      }
      paramdl.a().jdField_f_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramDataLineMsgSet.getAt(2).strMoloIconUrl);
      label173:
      if ((paramDataLineMsgSet.getTotalCount() < 4) || (paramDataLineMsgSet.getAt(3) == null) || (paramDataLineMsgSet.getAt(3).strMoloIconUrl == null)) {
        break label524;
      }
      paramdl.a().g.setAsyncImage(paramDataLineMsgSet.getAt(3).strMoloIconUrl);
      label218:
      paramdl.a().mFileName.setText(ahav.kY(paramDataLineMsgSet.getFileNames()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (!localDataLineMsgRecord.strMoloSource.contains(this.mContext.getString(2131695451)))) {
        break label540;
      }
      paramdl.a().O.setVisibility(8);
      paramdl.a().mFileName.setSingleLine(false);
      paramdl.a().mFileName.setMaxLines(2);
      label298:
      paramdl.a().mFileSize.setText(dx.g(paramDataLineMsgSet.getFileTotalSize()));
      if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
        break label578;
      }
      paramdl.a().P.setText(localDataLineMsgRecord.strMoloSource);
      paramdl.a().P.setVisibility(0);
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label374:
      if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
        break label593;
      }
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label422:
      if (!paramDataLineMsgSet.isCanceled()) {
        break label608;
      }
      paramdl.a().M.setText(2131695427);
    }
    for (;;)
    {
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label709;
      }
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return true;
      paramdl.a().d.setImageResource(2130845069);
      break;
      label492:
      paramdl.a().e.setImageResource(2130845069);
      break label128;
      label508:
      paramdl.a().jdField_f_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130845069);
      break label173;
      label524:
      paramdl.a().g.setImageResource(2130845069);
      break label218;
      label540:
      paramdl.a().O.setVisibility(0);
      paramdl.a().O.setText(2131695379);
      paramdl.a().mFileName.setSingleLine(true);
      break label298;
      label578:
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label374;
      label593:
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label422;
      label608:
      if (paramDataLineMsgSet.isFileComing()) {
        paramdl.a().M.setText(2131693600);
      } else if (i == j) {
        paramdl.a().M.setText("" + j);
      } else {
        paramdl.a().M.setText(i + "/" + j);
      }
    }
    label709:
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
    return true;
  }
  
  private void b(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ahhq.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.setType(10006);
    Intent localIntent = new Intent(this.mContext.getApplicationContext(), TroopFileDetailBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("forward_from_troop_file", true);
    localIntent.putExtra("not_forward", true);
    this.b.startActivityForResult(localIntent, 102);
  }
  
  private boolean b(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {
      return true;
    }
    if (paramdl.a().S == null) {
      return false;
    }
    if (paramDataLineMsgSet == null) {
      return true;
    }
    int j = paramDataLineMsgSet.getCompletedCount();
    int i = paramDataLineMsgSet.getTotalCount();
    DataLineMsgRecord localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    db.a locala;
    label149:
    label314:
    if (j == i)
    {
      paramdl.a().S.setText("" + i);
      j = ((Integer)paramdl.a().jdField_a_of_type_AndroidWidgetGridView.getTag()).intValue();
      locala = (db.a)paramdl.a().jdField_a_of_type_AndroidWidgetGridView.getAdapter();
      if (locala != null) {
        break label448;
      }
      locala = new db.a(paramdl, paramDataLineMsgSet, j, null);
      paramdl.a().jdField_a_of_type_AndroidWidgetGridView.setAdapter(locala);
      paramdl.a().u.setVisibility(8);
      paramDataLineMsgSet.printlog();
      if (((paramDataLineMsgSet.hasSendingOrRecving()) || (paramDataLineMsgSet.hasWaiting())) && (!paramDataLineMsgSet.isFileComing())) {
        break label502;
      }
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(4);
      if (!paramDataLineMsgSet.isCanceled()) {
        break label468;
      }
      paramdl.a().u.setVisibility(0);
      paramdl.a().R.setText(2131695427);
      label228:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label535;
          }
          paramdl.a().P.setText(localDataLineMsgRecord.strMoloSource);
          paramdl.a().P.setVisibility(0);
          paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label550;
          }
          paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramdl.a().jdField_q_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramDataLineMsgSet = String.format(this.mContext.getString(2131695413), new Object[] { Integer.valueOf(i) });
        paramdl.a().jdField_q_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramDataLineMsgSet);
      }
      return true;
      paramdl.a().S.setText(j + "/" + i);
      break;
      label448:
      locala.a = paramDataLineMsgSet;
      locala.b = paramdl;
      locala.refreshUI();
      break label149;
      label468:
      if (!paramDataLineMsgSet.isFileComing()) {
        break label228;
      }
      paramdl.a().u.setVisibility(0);
      paramdl.a().R.setText(2131693600);
      break label228;
      label502:
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(0);
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setProgress((int)(paramDataLineMsgSet.getTotalProcess() * 100.0F));
      break label228;
      label535:
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label314;
      label550:
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord = ahhq.a(paramDataLineMsgRecord.trans2Entity());
    paramDataLineMsgRecord.setType(10002);
    Intent localIntent = new Intent(this.mContext.getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramDataLineMsgRecord);
    localIntent.putExtra("removemementity", true);
    localIntent.putExtra("not_forward", true);
    this.b.startActivityForResult(localIntent, 102);
  }
  
  private void c(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      localDataLineMsgRecord = paramDataLineMsgSet.getFirstItem();
    } while (localDataLineMsgRecord == null);
    String str = ahbf.getRealPath(localDataLineMsgRecord.path);
    paramdl.a().h.setAsyncClipSize(this.dI, this.dJ);
    paramdl.a().h.setDefaultImageByMargin();
    paramdl.a().h.setIsDrawRound(true);
    paramdl.a().u.setVisibility(8);
    paramdl.a().Q.setVisibility(8);
    label317:
    if ((str != null) && (new VFSFile(str).exists()))
    {
      paramdl.a().h.setAsyncImage(str);
      label125:
      if ((localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        break label483;
      }
      paramdl.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
      paramdl.a().i.setVisibility(8);
      if ((localDataLineMsgRecord.fileMsgStatus != 1L) || (localDataLineMsgRecord.thumbPath != null)) {
        break label468;
      }
      paramdl.a().Q.setVisibility(0);
      paramdl.a().Q.setText(2131695390);
      label231:
      if (!paramDataLineMsgSet.isSendFromLocal())
      {
        paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        if (localDataLineMsgRecord.strMoloKey != null)
        {
          if ((localDataLineMsgRecord.strMoloSource == null) || (localDataLineMsgRecord.strMoloSource.equals(""))) {
            break label541;
          }
          paramdl.a().P.setText(localDataLineMsgRecord.strMoloSource);
          paramdl.a().P.setVisibility(0);
          paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((localDataLineMsgRecord.strMoloSrcIconUrl == null) || (localDataLineMsgRecord.strMoloSrcIconUrl.equals(""))) {
            break label556;
          }
          paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(localDataLineMsgRecord.strMoloSrcIconUrl);
          paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (paramdl.a().p != null) {
        paramdl.a().p.setContentDescription(acfp.m(2131704627));
      }
      if (paramdl.a().h == null) {
        break;
      }
      paramdl.a().h.setContentDescription(acfp.m(2131704619));
      return;
      if ((localDataLineMsgRecord.thumbPath != null) && (localDataLineMsgRecord.thumbPath.length() > 0))
      {
        paramdl.a().h.setAsyncImage(localDataLineMsgRecord.thumbPath);
        break label125;
      }
      paramdl.a().h.setImageDrawableDefault();
      break label125;
      label468:
      paramdl.a().Q.setVisibility(8);
      break label231;
      label483:
      if (localDataLineMsgRecord.isSendFromLocal())
      {
        paramdl.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
        int i = (int)(localDataLineMsgRecord.progress * 100.0F);
        paramdl.a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setProgress(i);
        break label231;
      }
      paramdl.a().i.setVisibility(0);
      break label231;
      label541:
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label317;
      label556:
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void d(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    while (paramDataLineMsgSet == null) {
      return;
    }
    paramdl.A.setTag(paramdl);
    if ((paramDataLineMsgSet.isSendFromLocal()) && (paramDataLineMsgSet.hasFailed()) && (!paramDataLineMsgSet.hasSendingOrRecving()) && (!paramDataLineMsgSet.hasWaiting())) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramdl.A.setVisibility(4);
      return;
    }
    paramdl.A.setVisibility(0);
    if (paramDataLineMsgSet.getOpType() == 1)
    {
      paramdl.A.setOnClickListener(this.b.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
    }
    paramdl.A.setOnClickListener(this.b.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private boolean isMsgEmpty()
  {
    return (this.a == null) || (this.a.size() == 0);
  }
  
  protected boolean H()
  {
    return this.aQ;
  }
  
  protected View a(int paramInt, dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    return null;
  }
  
  protected void a(int paramInt, dl paramdl, DataLineMsgSet paramDataLineMsgSet) {}
  
  public void a(long paramLong, ListView paramListView, float paramFloat)
  {
    Object localObject = null;
    if (paramListView == null) {}
    int i;
    DataLineMsgSet localDataLineMsgSet;
    int j;
    label168:
    label379:
    do
    {
      float f1;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i = this.a.getSetIndex(paramLong);
              } while (i == -1);
              paramListView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
            } while ((paramListView == null) || (i >= this.a.size()));
            localDataLineMsgSet = this.a.get(i);
            if (localDataLineMsgSet.mUpdateProcessTick == 0L) {}
            for (localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis();; localDataLineMsgSet.mUpdateProcessTick = System.currentTimeMillis())
            {
              if (!localDataLineMsgSet.isSingle()) {
                break label379;
              }
              j = DataLineMsgRecord.getDevTypeBySeId(paramLong);
              localObject = this.app.b().a(j).a(paramLong);
              if (localObject == null) {
                break;
              }
              if (!s(getItemViewType(i))) {
                break label168;
              }
              a((DataLineMsgRecord)localObject, paramListView, paramFloat);
              return;
              if (System.currentTimeMillis() - localDataLineMsgSet.mUpdateProcessTick < 1000L) {
                break;
              }
            }
            f1 = paramFloat;
            if (paramFloat < ((DataLineMsgRecord)localObject).progress) {
              f1 = ((DataLineMsgRecord)localObject).progress;
            }
            switch (((DataLineMsgRecord)localObject).msgtype)
            {
            default: 
              return;
            case -2335: 
            case -2009: 
            case -2005: 
              if (!((DataLineMsgRecord)localObject).bIsMoloImage) {
                break label272;
              }
              paramListView = (MessageProgressTextView)paramListView.findViewById(2131368838);
            }
          } while (paramListView == null);
          paramListView.setProgress((int)(f1 * 100.0F));
          return;
          localObject = (TextView)paramListView.findViewById(2131367075);
          paramListView = (ProgressBar)paramListView.findViewById(2131367035);
          if (paramListView != null)
          {
            paramListView.setVisibility(0);
            paramListView.setProgress((int)(f1 * 100.0F));
          }
        } while (localObject == null);
        ((TextView)localObject).setText((int)(f1 * 100.0F) + "%");
        return;
        paramListView = (MessageProgressTextView)paramListView.findViewById(2131368838);
      } while (paramListView == null);
      paramListView.setProgress((int)(f1 * 100.0F));
      return;
      paramListView = (dl)paramListView.getTag();
    } while (paramListView == null);
    label272:
    switch (localDataLineMsgSet.getGroupType())
    {
    default: 
      paramListView = null;
      label442:
      i = localDataLineMsgSet.getCompletedCount();
      j = localDataLineMsgSet.getTotalCount();
      if (localObject != null)
      {
        if (i != j) {
          break label542;
        }
        ((TextView)localObject).setText("" + j);
      }
      break;
    }
    while (paramListView != null)
    {
      if (i != j) {
        break label576;
      }
      paramListView.setVisibility(4);
      return;
      localObject = paramListView.a().M;
      paramListView = paramListView.a().jdField_f_of_type_AndroidWidgetProgressBar;
      break label442;
      paramListView = paramListView.a().jdField_f_of_type_AndroidWidgetProgressBar;
      break label442;
      label542:
      ((TextView)localObject).setText(i + "/" + j);
    }
    label576:
    paramListView.setVisibility(0);
    paramListView.setProgress((int)(localDataLineMsgSet.getTotalProcess() * 100.0F));
  }
  
  protected void a(View paramView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.isSendFromLocal())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, BaseChatItemLayout.bNV, BaseChatItemLayout.bNX, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.bNX, BaseChatItemLayout.bNV, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  protected void a(DataLineMsgRecord paramDataLineMsgRecord, View paramView, float paramFloat) {}
  
  public void a(DataLineMsgSetList paramDataLineMsgSetList)
  {
    this.a = paramDataLineMsgSetList;
  }
  
  protected void a(dl paramdl, View paramView, DataLineMsgRecord paramDataLineMsgRecord, adxp paramadxp)
  {
    if (paramadxp == null) {
      return;
    }
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      paramadxp = paramView.getResources();
      if (paramDataLineMsgRecord.isSendFromLocal())
      {
        paramView = paramadxp.getColorStateList(2131167326);
        paramdl.a().mText.setTextColor(paramView);
        if (!paramDataLineMsgRecord.isSendFromLocal()) {
          break label95;
        }
      }
      label95:
      for (paramView = paramadxp.getColorStateList(2131167325);; paramView = paramadxp.getColorStateList(2131167324))
      {
        paramdl.a().mText.setLinkTextColor(paramView);
        return;
        paramView = paramadxp.getColorStateList(2131167322);
        break;
      }
    }
    if (paramadxp.mTextColor == 0) {
      paramdl.a().mText.setTextColor(-16777216);
    }
    while (paramadxp.mLinkColor == 0)
    {
      paramdl.a().mText.setLinkTextColor(paramView.getResources().getColorStateList(2131167324));
      return;
      paramdl.a().mText.setTextColor(paramadxp.mTextColor);
    }
    paramdl.a().mText.setLinkTextColor(paramadxp.mLinkColor);
  }
  
  protected void a(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    paramdl.a().d.setIsDrawRound(false);
    ahav.a(paramdl.a().d, paramDataLineMsgSet);
    paramdl.a().mFileName.setText(ahav.kY(paramDataLineMsgSet.filename));
    paramdl.a().mFileSize.setText(dx.g(paramDataLineMsgSet.filesize));
    if (paramDataLineMsgSet.isSendFromLocal()) {
      if (paramDataLineMsgSet.fileMsgStatus == 2L) {
        paramdl.a().M.setText(2131695427);
      }
    }
    while ((paramDataLineMsgSet.progress == 1.0F) || (!paramDataLineMsgSet.issuc) || (paramDataLineMsgSet.fileMsgStatus == 1L) || (paramDataLineMsgSet.fileMsgStatus == 2L))
    {
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc))
      {
        paramdl.a().M.setText(2131693599);
      }
      else if (!paramDataLineMsgSet.issuc)
      {
        if (paramDataLineMsgSet.nOpType == 1) {
          paramdl.a().M.setText(2131693597);
        } else {
          paramdl.a().M.setText(2131693598);
        }
      }
      else
      {
        paramdl.a().M.setText(i + "%");
        continue;
        if (paramDataLineMsgSet.fileMsgStatus == 2L) {
          paramdl.a().M.setText(2131695427);
        } else if (paramDataLineMsgSet.fileMsgStatus == 1L) {
          paramdl.a().M.setText(2131693600);
        } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
          paramdl.a().M.setText(2131693591);
        } else if (!paramDataLineMsgSet.issuc) {
          paramdl.a().M.setText(2131693597);
        } else {
          paramdl.a().M.setText(i + "%");
        }
      }
    }
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  public boolean a(long paramLong, ListView paramListView)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    Object localObject = this.app.a(i).a(paramLong);
    if (isMsgEmpty()) {
      return false;
    }
    if (paramListView == null) {
      return true;
    }
    i = this.a.getSetIndex(paramLong);
    if (i == -1) {
      return false;
    }
    View localView = paramListView.getChildAt(i - paramListView.getFirstVisiblePosition());
    if (localView == null) {
      return false;
    }
    if (i >= this.a.size()) {
      return false;
    }
    paramListView = this.a.get(i);
    if ((localObject != null) && (((DataLineMsgRecord)localObject).fileMsgStatus == 1L)) {
      if (paramListView.mUpdateMutiViewTick != 0L) {
        break label138;
      }
    }
    for (paramListView.mUpdateMutiViewTick = System.currentTimeMillis(); paramListView.isSingle(); paramListView.mUpdateMutiViewTick = System.currentTimeMillis())
    {
      return true;
      label138:
      if (System.currentTimeMillis() - paramListView.mUpdateMutiViewTick < 1000L) {
        return true;
      }
    }
    localObject = (dl)localView.getTag();
    if (localObject == null) {
      return false;
    }
    switch (paramListView.getGroupType())
    {
    }
    do
    {
      do
      {
        do
        {
          d((dl)localObject, paramListView);
          return true;
          if (!paramListView.getFirstItem().bIsMoloImage) {
            break;
          }
        } while (b((dl)localObject, paramListView));
        return false;
      } while (a((dl)localObject, paramListView));
      return false;
    } while (b((dl)localObject, paramListView));
    return false;
  }
  
  protected void aM()
  {
    this.aQ = false;
    new Handler().postDelayed(new DatalineSessionAdapter.1(this), 1500L);
  }
  
  public int af()
  {
    return this.a.size();
  }
  
  protected void b(dl paramdl, DataLineMsgSet paramDataLineMsgSet)
  {
    if (paramdl == null) {}
    do
    {
      do
      {
        return;
      } while (paramDataLineMsgSet == null);
      paramDataLineMsgSet = paramDataLineMsgSet.getFirstItem();
    } while (paramDataLineMsgSet == null);
    int i = (int)(paramDataLineMsgSet.progress * 100.0F);
    if (paramDataLineMsgSet.strMoloIconUrl != null)
    {
      paramdl.a().d.setAsyncImage(paramDataLineMsgSet.strMoloIconUrl);
      paramdl.a().mFileName.setText(ahav.kY(paramDataLineMsgSet.filename));
      if ((paramDataLineMsgSet.strMoloSource == null) || (!paramDataLineMsgSet.strMoloSource.contains(this.mContext.getString(2131695451)))) {
        break label333;
      }
      paramdl.a().O.setVisibility(8);
      paramdl.a().mFileName.setSingleLine(false);
      paramdl.a().mFileName.setMaxLines(2);
      label127:
      paramdl.a().mFileSize.setText(dx.g(paramDataLineMsgSet.filesize));
      if ((paramDataLineMsgSet.strMoloSource == null) || (paramDataLineMsgSet.strMoloSource.equals(""))) {
        break label371;
      }
      paramdl.a().P.setText(paramDataLineMsgSet.strMoloSource);
      paramdl.a().P.setVisibility(0);
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      label200:
      if ((paramDataLineMsgSet.strMoloSrcIconUrl == null) || (paramDataLineMsgSet.strMoloSrcIconUrl.equals(""))) {
        break label386;
      }
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setImageURL(paramDataLineMsgSet.strMoloSrcIconUrl);
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      label245:
      if (paramDataLineMsgSet.fileMsgStatus != 2L) {
        break label401;
      }
      paramdl.a().M.setText(2131695427);
    }
    for (;;)
    {
      if ((paramDataLineMsgSet.progress != 1.0F) && (paramDataLineMsgSet.issuc) && (paramDataLineMsgSet.fileMsgStatus != 1L) && (paramDataLineMsgSet.fileMsgStatus != 2L)) {
        break label514;
      }
      paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(4);
      return;
      paramdl.a().d.setImageResource(2130845069);
      break;
      label333:
      paramdl.a().O.setVisibility(0);
      paramdl.a().O.setText(2131695379);
      paramdl.a().mFileName.setSingleLine(true);
      break label127;
      label371:
      paramdl.a().jdField_q_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label200;
      label386:
      paramdl.a().jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      break label245;
      label401:
      if (paramDataLineMsgSet.fileMsgStatus == 1L) {
        paramdl.a().M.setText(2131693600);
      } else if ((paramDataLineMsgSet.progress == 1.0F) && (paramDataLineMsgSet.issuc)) {
        paramdl.a().M.setText(2131693591);
      } else if (!paramDataLineMsgSet.issuc) {
        paramdl.a().M.setText(2131693597);
      } else {
        paramdl.a().M.setText(i + "%");
      }
    }
    label514:
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramdl.a().jdField_f_of_type_AndroidWidgetProgressBar.setProgress(i);
  }
  
  public long c(int paramInt)
  {
    return this.a.get(paramInt).getTime();
  }
  
  public long d(int paramInt)
  {
    return this.a.get(paramInt).getMsgId();
  }
  
  public int getCount()
  {
    if (isMsgEmpty()) {
      return 1;
    }
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (isMsgEmpty()) {
      return null;
    }
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 1;
    if (isMsgEmpty()) {
      paramInt = 13;
    }
    label137:
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      DataLineMsgSet localDataLineMsgSet;
      boolean bool;
      do
      {
        return paramInt;
        localDataLineMsgSet = this.a.get(paramInt);
        bool = localDataLineMsgSet.isSendFromLocal();
        switch (localDataLineMsgSet.getGroupType())
        {
        default: 
          return 12;
        case -1000: 
          if (bool) {
            return 7;
          }
          return 0;
        case -2000: 
          if (!localDataLineMsgSet.isSingle()) {
            break label137;
          }
          paramInt = i;
        }
      } while (!bool);
      return 8;
      if (bool) {
        return 9;
      }
      return 2;
      if (localDataLineMsgSet.isSingle())
      {
        if (bool) {
          return 10;
        }
        return 3;
      }
      if (bool) {
        return 11;
      }
      return 4;
      localDataLineMsgRecord = localDataLineMsgSet.getFirstItem();
      if (!localDataLineMsgSet.isSingle()) {
        break;
      }
      paramInt = i;
    } while (localDataLineMsgRecord.bIsMoloImage);
    return 5;
    if (localDataLineMsgRecord.bIsMoloImage) {
      return 2;
    }
    return 6;
    return 14;
    return 15;
    return 16;
  }
  
  @TargetApi(8)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (isMsgEmpty()) {
      if (paramView == null)
      {
        localObject1 = new dl();
        paramView = this.mInflater.inflate(2131559207, null);
        localObject2 = (TextView)paramView.findViewById(2131370599);
        localObject3 = (ImageView)paramView.findViewById(2131370598);
        if (this.b.cM == 1)
        {
          ((TextView)localObject2).setText(2131692406);
          ((ImageView)localObject3).setImageResource(2130840064);
        }
        paramView.setTag(localObject1);
        paramView.setVisibility(4);
        this.b.br();
        localObject1 = paramView;
      }
    }
    int i;
    DataLineMsgRecord localDataLineMsgRecord;
    label214:
    Object localObject4;
    int j;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
      localObject1 = (dl)paramView.getTag();
      break;
      this.b.br();
      localObject3 = this.a.get(paramInt);
      if (localObject3 == null)
      {
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
      else
      {
        i = getItemViewType(paramInt);
        localDataLineMsgRecord = ((DataLineMsgSet)localObject3).getFirstItem();
        if (paramView == null)
        {
          localObject2 = new dl();
          if (s(i))
          {
            paramView = a(i, (dl)localObject2, (DataLineMsgSet)localObject3);
            paramView.setTag(localObject2);
          }
        }
        for (localObject1 = localObject2;; localObject1 = (dl)paramView.getTag())
        {
          ((dl)localObject1).b((DataLineMsgSet)localObject3);
          if (i != 12) {
            break label3042;
          }
          localObject1 = paramView;
          break;
          if (i == 12) {
            break label214;
          }
          Object localObject5;
          if (i == 14)
          {
            paramView = this.mInflater.inflate(2131559182, null);
            localObject1 = ((dl)localObject2).a();
            ((dl.b)localObject1).mText = ((TextView)paramView.findViewById(2131368123));
            localObject4 = acfp.m(2131704638);
            localObject5 = acfp.m(2131704615);
            ((dl.b)localObject1).mText.setMaxLines(2);
            localObject5 = new SpannableString("还想把文件发到好友手机？快来用\n" + (String)localObject4 + (String)localObject5);
            ((SpannableString)localObject5).setSpan(new dd(this), "还想把文件发到好友手机？快来用\n".length(), "还想把文件发到好友手机？快来用\n".length() + ((String)localObject4).length(), 33);
            ((dl.b)localObject1).mText.setHighlightColor(0);
            ((dl.b)localObject1).mText.setText((CharSequence)localObject5);
            ((dl.b)localObject1).mText.setMovementMethod(LinkMovementMethod.getInstance());
            ((dl.b)localObject1).mText.setVisibility(8);
            break label214;
          }
          if (i == 15)
          {
            localObject1 = ((dl)localObject2).a();
            paramView = LayoutInflater.from(this.mContext).inflate(2131561074, null);
            ((dl.g)localObject1).mTextView = ((TextView)paramView.findViewById(2131368123));
            break label214;
          }
          if (i == 16)
          {
            localObject1 = ((dl)localObject2).a();
            paramView = LayoutInflater.from(this.mContext).inflate(2131558954, null);
            ((dl.g)localObject1).mTextView = ((TextView)paramView.findViewById(2131368123));
            ((dl.g)localObject1).mTextView.setMovementMethod(null);
            ((dl.g)localObject1).mTextView.setTextColor(paramView.getResources().getColorStateList(2131165571));
            break label214;
          }
          if (!((DataLineMsgSet)localObject3).isSendFromLocal())
          {
            localObject1 = this.mInflater.inflate(2131559196, null);
            localObject4 = (ImageView)((View)localObject1).findViewById(2131368698);
            paramView = this.b.getResources().getDrawable(2130845074);
            j = DataLineMsgRecord.getDevTypeBySet((DataLineMsgSet)localObject3);
            if (j == 0)
            {
              paramView = this.b.getResources().getDrawable(2130845074);
              label623:
              ((ImageView)localObject4).setImageDrawable(paramView);
              paramView = (View)localObject1;
              label632:
              ((dl)localObject2).o = ((RelativeLayout)paramView.findViewById(2131372014));
              ((dl)localObject2).o.setTag(localObject2);
              ((dl)localObject2).o.setClickable(true);
              ((dl)localObject2).o.setLongClickable(true);
              ((dl)localObject2).o.setOnClickListener(this.mOnClickListener);
              ((dl)localObject2).o.setOnLongClickListener(this.b.jdField_a_of_type_AndroidViewView$OnLongClickListener);
              ((dl)localObject2).o.setOnTouchListener(this.b.jdField_b_of_type_AndroidViewView$OnTouchListener);
              ((dl)localObject2).o.setAddStatesFromChildren(true);
              switch (i)
              {
              }
            }
          }
          for (;;)
          {
            ((dl)localObject2).a((ImageView)paramView.findViewById(2131366493));
            ((dl)localObject2).a((TextView)paramView.findViewById(2131365616));
            break;
            if (j != 1) {
              break label623;
            }
            paramView = this.b.getResources().getDrawable(2130845071);
            break label623;
            paramView = this.mInflater.inflate(2131559202, null);
            break label632;
            localObject1 = (RelativeLayout)this.mInflater.inflate(2131559203, null);
            ((dl)localObject2).o.addView((View)localObject1);
            ((dl)localObject2).a().t = ((RelativeLayout)localObject1);
            ((dl)localObject2).a().mText = ((TextView)paramView.findViewById(2131379401));
            ((dl)localObject2).a().t.setAddStatesFromChildren(true);
            ((dl)localObject2).a().mText.setTag(localObject2);
            ((dl)localObject2).a().mText.setOnClickListener(this.mOnClickListener);
            ((dl)localObject2).a().mText.setClickable(true);
            ((dl)localObject2).a().mText.setOnLongClickListener(this.b.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((dl)localObject2).a().mText.setOnTouchListener(this.b.jdField_b_of_type_AndroidViewView$OnTouchListener);
            ((dl)localObject2).a().mText.setLongClickable(true);
            ((dl)localObject2).a().mText.setMovementMethod(LinkMovementMethod.getInstance());
            ((dl)localObject2).a().mText.setSpannableFactory(aofk.a);
            if (((DataLineMsgSet)localObject3).isSendFromLocal()) {}
            for (localObject1 = this.mContext.getResources().getColorStateList(2131167326);; localObject1 = this.mContext.getResources().getColorStateList(2131167322))
            {
              ((dl)localObject2).a().mText.setTextColor((ColorStateList)localObject1);
              ((dl)localObject2).a((ProgressBar)paramView.findViewById(2131378035));
              if (((dl)localObject2).a() == null) {
                break;
              }
              ((dl)localObject2).a().setVisibility(8);
              break;
            }
            localObject1 = (RelativeLayout)this.mInflater.inflate(2131559183, null);
            ((dl)localObject2).o.addView((View)localObject1);
            ((dl)localObject2).o.setGravity(17);
            ((dl)localObject2).a().p = ((RelativeLayout)localObject1);
            ((dl)localObject2).a().h = ((AsyncImageView)paramView.findViewById(2131368820));
            ((dl)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView = ((MessageProgressTextView)paramView.findViewById(2131368838));
            ((dl)localObject2).a().i = ((ProgressBar)paramView.findViewById(2131376833));
            ((dl)localObject2).a().u = ((LinearLayout)paramView.findViewById(2131378719));
            ((dl)localObject2).a().Q = ((TextView)paramView.findViewById(2131364668));
            ((dl)localObject2).a().R = ((TextView)paramView.findViewById(2131381115));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((dl)localObject2).a().P = ((TextView)paramView.findViewById(2131381114));
              ((dl)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368748));
              ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378584));
            }
            if (((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((dl)localObject2).a().i.setVisibility(8);
              ((dl)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(0);
              a((dl)localObject2, this.dI, this.dJ);
              label1394:
              ((dl)localObject2).a().h.setAsyncClipSize(this.dI, this.dJ);
              ((dl)localObject2).a().h.setDefaultImageByMargin();
              if (BaseBubbleBuilder.bdm) {
                break label1519;
              }
              ((dl)localObject2).a().h.setAdjustViewBounds(true);
            }
            for (;;)
            {
              ((dl)localObject2).a().h.setIsDrawRound(true);
              ((dl)localObject2).a().p.setContentDescription(acfp.m(2131704625));
              ((dl)localObject2).a().h.setContentDescription(acfp.m(2131704633));
              break;
              ((dl)localObject2).a().i.setVisibility(0);
              ((dl)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setVisibility(8);
              break label1394;
              label1519:
              localObject1 = new wyf(2130706432, this.b.getDensity() * 12.0F);
              ((dl)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setBackgroundDrawable((Drawable)localObject1);
              j = (int)TypedValue.applyDimension(2, 15.0F, this.mContext.getResources().getDisplayMetrics());
              ((dl)localObject2).a().jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.setDisplayInTextView(false, j, -1);
            }
            localObject1 = (RelativeLayout)this.mInflater.inflate(2131559185, null);
            ((dl)localObject2).o.addView((View)localObject1);
            ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
            ((dl)localObject2).a().S = ((TextView)paramView.findViewById(2131373261));
            ((dl)localObject2).a().jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131373232));
            ((dl)localObject2).a().jdField_f_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131367035));
            ((dl)localObject2).a().u = ((LinearLayout)paramView.findViewById(2131378719));
            ((dl)localObject2).a().R = ((TextView)paramView.findViewById(2131381115));
            if (!((DataLineMsgSet)localObject3).isSendFromLocal())
            {
              ((dl)localObject2).a().P = ((TextView)paramView.findViewById(2131381114));
              ((dl)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368748));
              ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378584));
            }
            ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
            ((dl)localObject2).a().S.setTag(localObject2);
            ((dl)localObject2).a().S.setOnClickListener(this.mOnClickListener);
            ((dl)localObject2).a().S.setClickable(true);
            ((dl)localObject2).a().S.setOnLongClickListener(this.b.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((dl)localObject2).a().S.setOnTouchListener(this.b.jdField_b_of_type_AndroidViewView$OnTouchListener);
            ((dl)localObject2).a().S.setLongClickable(true);
            a(((dl)localObject2).a().jdField_a_of_type_AndroidWidgetGridView);
            continue;
            localObject4 = (RelativeLayout)this.mInflater.inflate(2131559178, null);
            ((dl)localObject2).o.addView((View)localObject4);
            if (acej.aV() > 17.0F)
            {
              ((dl)localObject2).a().n = ((RelativeLayout)localObject4);
              j = wja.dp2px(70.0F, this.mContext.getResources());
              localObject1 = (RelativeLayout)paramView.findViewById(2131367050);
              localObject5 = new RelativeLayout.LayoutParams(-1, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131367057);
              ((RelativeLayout)localObject4).updateViewLayout((View)localObject1, (ViewGroup.LayoutParams)localObject5);
              localObject4 = (AsyncImageView)paramView.findViewById(2131367022);
              ((AsyncImageView)localObject4).setScaleType(ImageView.ScaleType.CENTER_CROP);
              localObject5 = new RelativeLayout.LayoutParams(j, j);
              ((RelativeLayout.LayoutParams)localObject5).addRule(9, 2131367050);
              ((RelativeLayout.LayoutParams)localObject5).addRule(15, 2131367050);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((dl)localObject2).a().d = ((AsyncImageView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131367070);
              ((TextView)localObject4).setGravity(16);
              localObject5 = new RelativeLayout.LayoutParams(-1, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(1, 2131367022);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131367050);
              ((RelativeLayout.LayoutParams)localObject5).addRule(10, 2131367050);
              ((RelativeLayout.LayoutParams)localObject5).setMargins(wja.dp2px(10.0F, this.mContext.getResources()), 0, 0, 0);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((dl)localObject2).a().mFileName = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131367075);
              ((TextView)localObject4).setGravity(5);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131367050);
              ((RelativeLayout.LayoutParams)localObject5).addRule(12, 2131367050);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((dl)localObject2).a().M = ((TextView)localObject4);
              localObject4 = (TextView)paramView.findViewById(2131367074);
              ((TextView)localObject4).setGravity(17);
              localObject5 = new RelativeLayout.LayoutParams(-2, -2);
              ((RelativeLayout.LayoutParams)localObject5).addRule(11, 2131367050);
              ((RelativeLayout.LayoutParams)localObject5).addRule(2, 2131367075);
              ((RelativeLayout)localObject1).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject5);
              ((dl)localObject2).a().mFileSize = ((TextView)localObject4);
            }
            for (;;)
            {
              ((dl)localObject2).a().jdField_f_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131367035));
              ((dl)localObject2).a().d.setDefaultImage(2130851854);
              ((dl)localObject2).a().d.setIsDrawRound(false);
              break;
              ((dl)localObject2).a().n = ((RelativeLayout)localObject4);
              ((dl)localObject2).a().d = ((AsyncImageView)paramView.findViewById(2131367022));
              ((dl)localObject2).a().mFileName = ((TextView)paramView.findViewById(2131367070));
              ((dl)localObject2).a().mFileSize = ((TextView)paramView.findViewById(2131367074));
              ((dl)localObject2).a().M = ((TextView)paramView.findViewById(2131367075));
            }
            localObject1 = (RelativeLayout)this.mInflater.inflate(2131559176, null);
            ((dl)localObject2).o.addView((View)localObject1);
            ((dl)localObject2).a().n = ((RelativeLayout)localObject1);
            ((dl)localObject2).a().d = ((AsyncImageView)paramView.findViewById(2131367022));
            ((dl)localObject2).a().mFileName = ((TextView)paramView.findViewById(2131367070));
            ((dl)localObject2).a().O = ((TextView)paramView.findViewById(2131367038));
            ((dl)localObject2).a().mFileSize = ((TextView)paramView.findViewById(2131367074));
            ((dl)localObject2).a().M = ((TextView)paramView.findViewById(2131367075));
            ((dl)localObject2).a().jdField_f_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131367035));
            ((dl)localObject2).a().P = ((TextView)paramView.findViewById(2131381114));
            ((dl)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368748));
            ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378584));
            ((dl)localObject2).a().d.setDefaultImage(2130845068);
            ((dl)localObject2).a().d.setIsDrawRound(false);
            continue;
            localObject1 = (RelativeLayout)this.mInflater.inflate(2131559184, null);
            ((dl)localObject2).o.addView((View)localObject1);
            ((dl)localObject2).a().n = ((RelativeLayout)localObject1);
            ((dl)localObject2).a().d = ((AsyncImageView)paramView.findViewById(2131367023));
            ((dl)localObject2).a().e = ((AsyncImageView)paramView.findViewById(2131367024));
            ((dl)localObject2).a().jdField_f_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131367025));
            ((dl)localObject2).a().g = ((AsyncImageView)paramView.findViewById(2131367026));
            ((dl)localObject2).a().mFileName = ((TextView)paramView.findViewById(2131367070));
            ((dl)localObject2).a().O = ((TextView)paramView.findViewById(2131367038));
            ((dl)localObject2).a().mFileSize = ((TextView)paramView.findViewById(2131367074));
            ((dl)localObject2).a().M = ((TextView)paramView.findViewById(2131367075));
            ((dl)localObject2).a().jdField_f_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131367035));
            ((dl)localObject2).a().P = ((TextView)paramView.findViewById(2131381114));
            ((dl)localObject2).a().jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368748));
            ((dl)localObject2).a().jdField_q_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378584));
            ((dl)localObject2).a().d.setDefaultImage(2130845069);
            ((dl)localObject2).a().e.setDefaultImage(2130845069);
            ((dl)localObject2).a().jdField_f_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130845069);
            ((dl)localObject2).a().g.setDefaultImage(2130845069);
            ((dl)localObject2).a().d.setIsDrawRound(false);
            ((dl)localObject2).a().e.setIsDrawRound(false);
            ((dl)localObject2).a().jdField_f_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
            ((dl)localObject2).a().g.setIsDrawRound(false);
          }
        }
        label3042:
        if (i == 14)
        {
          if (ThemeUtil.isInNightMode(this.app))
          {
            localObject2 = (afeh)this.b.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361820);
            if (localObject2 != null)
            {
              i = wkj.c(((afeh)localObject2).getBitmap());
              ((dl)localObject1).a().mText.setTextColor(ColorStateList.valueOf(i));
            }
          }
          localObject1 = paramView;
        }
        else if (i == 15)
        {
          localObject1 = ((dl)localObject1).a();
          localObject2 = ahav.a(localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_tips"), localDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_link"), new de(this, localDataLineMsgRecord));
          ((dl.g)localObject1).mTextView.setText((CharSequence)localObject2);
          ((dl.g)localObject1).mTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((dl.g)localObject1).mTextView.setHighlightColor(17170445);
          localObject1 = paramView;
        }
        else
        {
          if (i != 16) {
            break label3316;
          }
          localObject2 = ((dl)localObject1).a();
          if ((localDataLineMsgRecord == null) || (TextUtils.isEmpty(localDataLineMsgRecord.msg)) || (((dl.g)localObject2).mTextView == null) || (localDataLineMsgRecord.msg.indexOf(acfp.m(2131704628)) < 0)) {
            break label3316;
          }
          localObject1 = ahav.a(localDataLineMsgRecord.msg, acfp.m(2131704616), new df(this, localDataLineMsgRecord));
          ((dl.g)localObject2).mTextView.setText((CharSequence)localObject1);
          ((dl.g)localObject2).mTextView.setMovementMethod(LinkMovementMethod.getInstance());
          ((dl.g)localObject2).mTextView.setHighlightColor(17170445);
          localObject1 = paramView;
        }
      }
    }
    label3316:
    switch (i)
    {
    }
    for (;;)
    {
      if (!s(i)) {
        break label3609;
      }
      a(i, (dl)localObject1, (DataLineMsgSet)localObject3);
      localObject1 = paramView;
      break;
      ((dl)localObject1).a().bM = localDataLineMsgRecord.msg;
      ((dl)localObject1).a().mSessionId = localDataLineMsgRecord.sessionid;
      localObject2 = ((dl)localObject1).a().mText;
      localObject4 = acbn.bkw;
      localObject4 = new aofk(localDataLineMsgRecord.msg, 13, 32, 6000);
      ((aofk)localObject4).RO("biz_src_jc_aio");
      ((TextView)localObject2).setText((CharSequence)localObject4);
      ((TextView)localObject2).setVisibility(0);
      if (((dl)localObject1).a() != null)
      {
        if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.progress == 1.0F)) {
          break label3539;
        }
        ((dl)localObject1).a().setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject2).setTextSize(0, ChatTextSizeSettingActivity.ag(this.mContext.getApplicationContext()));
        break;
        label3539:
        ((dl)localObject1).a().setVisibility(8);
      }
      c((dl)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((dl)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((dl)localObject1, (DataLineMsgSet)localObject3);
      continue;
      b((dl)localObject1, (DataLineMsgSet)localObject3);
      continue;
      a((dl)localObject1, (DataLineMsgSet)localObject3);
    }
    label3609:
    a(localDataLineMsgRecord, ((dl)localObject1).o, (dl)localObject1);
    int k;
    int m;
    if (ThemeUtil.isDefaultTheme())
    {
      i = ((dl)localObject1).o.getPaddingLeft();
      j = ((dl)localObject1).o.getPaddingRight();
      k = ((dl)localObject1).o.getPaddingTop();
      m = ((dl)localObject1).o.getPaddingBottom();
      if (!((DataLineMsgSet)localObject3).isSendFromLocal()) {
        ((dl)localObject1).o.setPadding(i + (int)(2.0F * this.b.getDensity()), k, j, m);
      }
    }
    else
    {
      label3703:
      if (ThemeUtil.isInNightMode(this.app))
      {
        localObject2 = (afeh)this.b.jdField_a_of_type_ComTencentWidgetXPanelContainer.getTag(2131361820);
        if (localObject2 != null)
        {
          i = wkj.c(((afeh)localObject2).getBitmap());
          ((dl)localObject1).a().setTextColor(ColorStateList.valueOf(i));
        }
      }
      if (!e(((DataLineMsgSet)localObject3).getMsgId())) {
        break label3853;
      }
      localObject2 = aqmu.a(this.mContext, 3, ((DataLineMsgSet)localObject3).getTime() * 1000L);
      ((dl)localObject1).a().setVisibility(0);
      ((dl)localObject1).a().setText((CharSequence)localObject2);
    }
    for (;;)
    {
      d((dl)localObject1, (DataLineMsgSet)localObject3);
      localObject1 = paramView;
      break;
      ((dl)localObject1).o.setPadding(i, k, j + (int)(2.0F * this.b.getDensity()), m);
      break label3703;
      label3853:
      ((dl)localObject1).a().setVisibility(8);
    }
  }
  
  public int getViewTypeCount()
  {
    return 17;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    ck();
    if (QLog.isColorLevel()) {
      QLog.d("DatalineSessionAdapter", 2, " notifyDataSetChanged ---------->");
    }
  }
  
  protected boolean s(int paramInt)
  {
    return false;
  }
  
  class a
    extends BaseAdapter
  {
    public DataLineMsgSet a;
    private AsyncImageView[] a;
    public dl b;
    private int mImageHeight;
    private int mImageWidth;
    
    private a(dl paramdl, DataLineMsgSet paramDataLineMsgSet, int paramInt)
    {
      this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView = new AsyncImageView[3];
      this.b = paramdl;
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet = paramDataLineMsgSet;
      this.mImageWidth = paramInt;
      this.mImageHeight = paramInt;
      initImageView();
    }
    
    private void initImageView()
    {
      int i = 0;
      while (i < 3)
      {
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i] = new AsyncImageView(db.this.b);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLayoutParams(new AbsListView.LayoutParams(this.mImageWidth, this.mImageHeight));
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAdjustViewBounds(false);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setDefaultImage(2130851854);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setIsDrawRound(false);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setAsyncClipSize(this.mImageWidth, this.mImageHeight);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setTag(this.b);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setClickable(true);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setLongClickable(true);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnClickListener(db.this.mOnClickListener);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnLongClickListener(db.this.b.a);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setOnTouchListener(db.this.b.b);
        this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i].setContentDescription(acfp.m(2131704619));
        i += 1;
      }
    }
    
    public int getCount()
    {
      return 3;
    }
    
    public Object getItem(int paramInt)
    {
      return this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      if (paramInt >= 3) {
        localObject = null;
      }
      DataLineMsgRecord localDataLineMsgRecord;
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
        localObject = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[paramInt];
        ((AsyncImageView)localObject).setTag(this.b);
        localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(paramInt);
        if (localDataLineMsgRecord != null) {
          break;
        }
        ((AsyncImageView)localObject).setImageResource(2130851854);
      }
      String str = ahbf.getRealPath(localDataLineMsgRecord.path);
      if ((str != null) && (new VFSFile(str).exists())) {
        ((AsyncImageView)localObject).setAsyncImage(str);
      }
      for (;;)
      {
        break;
        if (localDataLineMsgRecord.thumbPath != null) {
          ((AsyncImageView)localObject).setAsyncImage(localDataLineMsgRecord.thumbPath);
        }
      }
    }
    
    public void refreshUI()
    {
      int i = 0;
      if (i < 3)
      {
        AsyncImageView localAsyncImageView = this.jdField_a_of_type_ArrayOfComDatalineUtilWidgetAsyncImageView[i];
        localAsyncImageView.setTag(this.b);
        DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getAt(i);
        if (localDataLineMsgRecord == null) {
          localAsyncImageView.setImageResource(2130851854);
        }
        for (;;)
        {
          i += 1;
          break;
          String str = ahbf.getRealPath(localDataLineMsgRecord.path);
          if ((str != null) && (new VFSFile(str).exists())) {
            localAsyncImageView.setAsyncImage(str);
          } else if (localDataLineMsgRecord.thumbPath != null) {
            localAsyncImageView.setAsyncImage(localDataLineMsgRecord.thumbPath);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     db
 * JD-Core Version:    0.7.0.1
 */