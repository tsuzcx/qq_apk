package com.tencent.qqmail.thirdpartycall;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.AttachNamesHandlerTextView;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;

public class ThirdPartyCallDialog
  extends ReportDialog
{
  private static final String TAG = "ThirdPartyCallDialog";
  private LinearLayout mDialogLayout;
  private TextView mTipView;
  
  private ThirdPartyCallDialog(Context paramContext)
  {
    super(paramContext);
    getWindow().requestFeature(1);
    init();
  }
  
  public static Bitmap generateAttachmentIcon(Bitmap[] paramArrayOfBitmap)
  {
    if (paramArrayOfBitmap.length == 0) {
      return null;
    }
    int k = QMUIKit.dpToPx(3);
    int m = paramArrayOfBitmap[0].getWidth();
    int n = paramArrayOfBitmap[0].getHeight();
    int i1 = QMUIKit.dpToPx(1);
    if (paramArrayOfBitmap.length > 3) {}
    Bitmap localBitmap;
    for (int i = 3;; i = paramArrayOfBitmap.length)
    {
      int i2 = i - 1;
      localBitmap = Bitmap.createBitmap(k * i2 + m + i1 * i2, k * i2 + n + i1 * i2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setColor(-592138);
      int j = 0;
      while (j < i)
      {
        localCanvas.drawRect((i2 - j) * k, j * k, (i2 - j) * k + i1 * i2 + m, j * k + i1 * i2 + n, localPaint);
        localCanvas.drawBitmap(paramArrayOfBitmap[j], (i2 - j) * k + i1, k * j + i1, null);
        j += 1;
      }
    }
    return localBitmap;
  }
  
  public static Bitmap[] getBitmapArrWithFileUrls(List<String> paramList, Context paramContext)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Bitmap[] arrayOfBitmap = new Bitmap[paramList.size()];
      int k = paramList.size();
      paramList = paramList.iterator();
      int i = 0;
      int j = 0;
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (k - 3 > i)
        {
          i += 1;
        }
        else
        {
          i += 1;
          int m = ImageResourceUtil.getImageResource(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(str)), ImageResourceUtil.IMAGE_SIZE_76);
          arrayOfBitmap[j] = ((BitmapDrawable)paramContext.getResources().getDrawable(m)).getBitmap();
          j += 1;
        }
      }
      return arrayOfBitmap;
    }
    return null;
  }
  
  private void init()
  {
    this.mDialogLayout = ((LinearLayout)getLayoutInflater().inflate(2131559223, null));
    this.mTipView = ((TextView)this.mDialogLayout.findViewById(2131379710));
    setContentView(this.mDialogLayout);
  }
  
  public void createwithParams(TPCDialogParams paramTPCDialogParams)
  {
    Object localObject;
    TextView localTextView;
    ImageView localImageView;
    if (paramTPCDialogParams.mCanceledOnTouchOutside)
    {
      setCanceledOnTouchOutside(true);
      if (paramTPCDialogParams.animationsId != -1) {
        getWindow().setWindowAnimations(paramTPCDialogParams.animationsId);
      }
      localObject = (AttachNamesHandlerTextView)this.mDialogLayout.findViewById(2131363069);
      localTextView = (TextView)this.mDialogLayout.findViewById(2131363068);
      localImageView = (ImageView)this.mDialogLayout.findViewById(2131363065);
      if (paramTPCDialogParams.mFilePaths.size() <= 3) {
        break label359;
      }
      ((AttachNamesHandlerTextView)localObject).setText(TPCDialogParams.mTitleHeader.toString(), paramTPCDialogParams.mTitle, TPCDialogParams.mTitleMul + paramTPCDialogParams.mFilecount);
      label121:
      if (paramTPCDialogParams.mFilePaths.size() <= 1) {
        break label432;
      }
      localTextView.setText("共 " + paramTPCDialogParams.mReadebleFileSize);
      label157:
      if ((AccountManager.shareInstance().getAccountList().hasQQMailAccounts()) && (paramTPCDialogParams.mFileSize >= 52428800L))
      {
        this.mTipView.setVisibility(0);
        if (paramTPCDialogParams.mFilePaths.size() == 1) {
          this.mTipView.setText(QMApplicationContext.sharedInstance().getString(2131690593));
        }
        KvHelper.eventOpeninBigattachmentShow(new double[0]);
      }
      if (paramTPCDialogParams.mFilePaths == null) {
        break label446;
      }
      localImageView.setImageBitmap(generateAttachmentIcon(getBitmapArrWithFileUrls(paramTPCDialogParams.mFilePaths, getContext())));
    }
    for (;;)
    {
      if (paramTPCDialogParams.mOnDismissListener != null) {
        setOnDismissListener(new ThirdPartyCallDialog.1(this, paramTPCDialogParams));
      }
      if (paramTPCDialogParams.mOnCancelListener != null) {
        setOnCancelListener(paramTPCDialogParams.mOnCancelListener);
      }
      if ((paramTPCDialogParams.mListViewData != null) && (paramTPCDialogParams.mListViewData.size() > 0))
      {
        localObject = (ListView)this.mDialogLayout.findViewById(2131363066);
        ((ListView)localObject).setAdapter(new DataAdapter(paramTPCDialogParams.mListViewData, paramTPCDialogParams.mListItemCallback));
        ((ListView)localObject).setOnItemClickListener(new ThirdPartyCallDialog.2(this, paramTPCDialogParams));
      }
      return;
      setCanceledOnTouchOutside(false);
      break;
      label359:
      if (paramTPCDialogParams.mFilePaths.size() > 1)
      {
        ((AttachNamesHandlerTextView)localObject).setText(TPCDialogParams.mTitleHeader.toString(), paramTPCDialogParams.mTitle, "\b" + paramTPCDialogParams.mFilecount);
        break label121;
      }
      ((AttachNamesHandlerTextView)localObject).setText(TPCDialogParams.mTitleHeader.toString(), paramTPCDialogParams.mTitle, TPCDialogParams.mTitleTail.toString());
      break label121;
      label432:
      localTextView.setText(paramTPCDialogParams.mReadebleFileSize.toString());
      break label157;
      label446:
      localImageView.setImageResource(2130840420);
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void show()
  {
    super.show();
    Window localWindow = getWindow();
    localWindow.setGravity(80);
    localWindow.getDecorView().setPadding(0, 0, 0, 0);
    localWindow.setBackgroundDrawableResource(17170445);
    localWindow.setLayout(-1, -2);
  }
  
  public static class Builder
  {
    private ThirdPartyCallDialog.TPCDialogParams params;
    
    public Builder(Context paramContext)
    {
      this.params = new ThirdPartyCallDialog.TPCDialogParams(paramContext);
    }
    
    public ThirdPartyCallDialog create()
    {
      ThirdPartyCallDialog localThirdPartyCallDialog = new ThirdPartyCallDialog(this.params.mContext, null);
      localThirdPartyCallDialog.createwithParams(this.params);
      return localThirdPartyCallDialog;
    }
    
    public Context getContext()
    {
      return this.params.mContext;
    }
    
    public Builder setAnimationsID(int paramInt)
    {
      this.params.animationsId = paramInt;
      return this;
    }
    
    public Builder setCanceledOnTouchOutside(boolean paramBoolean)
    {
      this.params.mCanceledOnTouchOutside = paramBoolean;
      return this;
    }
    
    public Builder setData(List<ThirdPartyCallDialog.ThirdPartyBottomSheetData> paramList)
    {
      this.params.mListViewData = paramList;
      return this;
    }
    
    public Builder setFilePahts(List<String> paramList)
    {
      this.params.mFilePaths = paramList;
      return this;
    }
    
    public Builder setFileSize(long paramLong)
    {
      this.params.mFileSize = paramLong;
      this.params.mReadebleFileSize = new StringBuffer(StringExtention.getHumanReadableSizeString(paramLong));
      return this;
    }
    
    public Builder setFilecount(int paramInt)
    {
      this.params.mFilecount = new StringBuffer(" " + String.valueOf(paramInt)).append(ThirdPartyCallDialog.TPCDialogParams.mTitleMulTail);
      return this;
    }
    
    public Builder setListItemCallback(ThirdPartyCallDialog.ListItemCallback paramListItemCallback)
    {
      this.params.mListItemCallback = paramListItemCallback;
      return this;
    }
    
    public Builder setOnCancelListener(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.params.mOnCancelListener = paramOnCancelListener;
      return this;
    }
    
    public Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.params.mOnDismissListener = paramOnDismissListener;
      return this;
    }
    
    public Builder setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
    {
      this.params.mOnItemClickListener = paramOnItemClickListener;
      return this;
    }
    
    public Builder setTitle(String[] paramArrayOfString)
    {
      this.params.mTitle = paramArrayOfString;
      return this;
    }
    
    public ThirdPartyCallDialog show()
    {
      ThirdPartyCallDialog localThirdPartyCallDialog = create();
      localThirdPartyCallDialog.show();
      return localThirdPartyCallDialog;
    }
  }
  
  class DataAdapter
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    private ThirdPartyCallDialog.ListItemCallback mListItemCallback;
    private List<ThirdPartyCallDialog.ThirdPartyBottomSheetData> mListViewData;
    
    public DataAdapter(ThirdPartyCallDialog.ListItemCallback paramListItemCallback)
    {
      this.mListViewData = paramListItemCallback;
      Object localObject;
      this.mListItemCallback = localObject;
      this.mInflater = LayoutInflater.from(ThirdPartyCallDialog.this.getContext());
    }
    
    public int getCount()
    {
      if (this.mListViewData != null) {
        return this.mListViewData.size();
      }
      return 0;
    }
    
    public ThirdPartyCallDialog.ThirdPartyBottomSheetData getItem(int paramInt)
    {
      if (this.mListViewData != null) {
        return (ThirdPartyCallDialog.ThirdPartyBottomSheetData)this.mListViewData.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        paramView = new ThirdPartyCallDialog.ViewHolder(ThirdPartyCallDialog.this);
        localView = this.mInflater.inflate(2131559232, paramViewGroup, false);
        paramView.mImageView = ((ImageView)localView.findViewById(2131363657));
        paramView.mTextView = ((TextView)localView.findViewById(2131363660));
        localView.setTag(paramView);
      }
      for (;;)
      {
        if (this.mListItemCallback != null) {
          this.mListItemCallback.onCallback(paramInt, paramView.mTextView);
        }
        Object localObject = getItem(paramInt);
        paramView.mImageView.setImageResource(((ThirdPartyCallDialog.ThirdPartyBottomSheetData)localObject).imageResId);
        paramView.mTextView.setText(((ThirdPartyCallDialog.ThirdPartyBottomSheetData)localObject).title);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ThirdPartyCallDialog.ViewHolder)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
  }
  
  public static abstract interface ListItemCallback
  {
    public abstract void onCallback(int paramInt, View paramView);
  }
  
  public static class TPCDialogParams
  {
    public static final StringBuffer mTitleHeader = new StringBuffer("添加 ");
    public static final StringBuffer mTitleMul = new StringBuffer(" 等");
    public static final StringBuffer mTitleMulTail = new StringBuffer("个文件为附件");
    public static final StringBuffer mTitleTail = new StringBuffer(" 为附件");
    public int animationsId = -1;
    public boolean mCanceledOnTouchOutside = false;
    public final Context mContext;
    public List<String> mFilePaths = null;
    public long mFileSize = 0L;
    public StringBuffer mFilecount = new StringBuffer("1");
    public ThirdPartyCallDialog.ListItemCallback mListItemCallback;
    public List<ThirdPartyCallDialog.ThirdPartyBottomSheetData> mListViewData = null;
    public DialogInterface.OnCancelListener mOnCancelListener;
    public DialogInterface.OnDismissListener mOnDismissListener;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public StringBuffer mReadebleFileSize = new StringBuffer("0M");
    public String[] mTitle = new String[0];
    
    public TPCDialogParams(Context paramContext)
    {
      this.mContext = paramContext;
    }
  }
  
  public static class ThirdPartyBottomSheetData
  {
    int imageResId;
    String title;
    
    public ThirdPartyBottomSheetData(int paramInt, String paramString)
    {
      this.imageResId = paramInt;
      this.title = paramString;
    }
  }
  
  public class ViewHolder
  {
    ImageView mImageView;
    TextView mTextView;
    
    public ViewHolder() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.thirdpartycall.ThirdPartyCallDialog
 * JD-Core Version:    0.7.0.1
 */