package com.tencent.qqmail.model.verify;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.EditTextDialogBuilder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.view.dialog.VerifyInputDialogBuilder;

public class QMVerifyImageDialog
{
  private int accountId;
  private String authImagesId;
  private String imgUrl;
  private View loadingBox;
  private Context mContext;
  private int retryVerifyCount = 0;
  private int verifyId;
  private ImageView verifyImageView;
  private String verifyKey;
  private String verifySession;
  
  public QMVerifyImageDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    this.mContext = paramContext;
    this.accountId = paramInt1;
    this.verifyId = paramInt2;
  }
  
  private void showVerifyImageDialog(Bitmap paramBitmap, SendVeifyCallBack paramSendVeifyCallBack)
  {
    if (this.verifyImageView != null)
    {
      if (this.loadingBox != null) {
        this.loadingBox.setVisibility(8);
      }
      if (paramBitmap != null)
      {
        this.verifyImageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
        return;
      }
      this.verifyImageView.setImageResource(2130841107);
      return;
    }
    VerifyInputDialogBuilder localVerifyInputDialogBuilder = new VerifyInputDialogBuilder(this.mContext);
    EditText localEditText = localVerifyInputDialogBuilder.getEditText();
    this.verifyImageView = localVerifyInputDialogBuilder.getRightImageView();
    this.loadingBox = localVerifyInputDialogBuilder.getLoadingBox();
    this.verifyImageView.setOnClickListener(new QMVerifyImageDialog.2(this));
    this.loadingBox.setVisibility(8);
    if (paramBitmap != null)
    {
      this.verifyImageView.setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
      if (this.retryVerifyCount <= 1) {
        break label249;
      }
    }
    label249:
    for (int i = 2131721672;; i = 2131721675)
    {
      paramBitmap = ((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)((QMUIDialog.EditTextDialogBuilder)localVerifyInputDialogBuilder.setTitle(i)).setPlaceholder(2131721666).addAction(2131691246, new QMVerifyImageDialog.4(this))).addAction(2131719473, new QMVerifyImageDialog.3(this, localEditText, paramSendVeifyCallBack))).create();
      paramBitmap.setOnDismissListener(new QMVerifyImageDialog.5(this));
      paramBitmap.show();
      KeyBoardHelper.showSoftInputDelay(localEditText, 500L);
      return;
      this.verifyImageView.setImageResource(2130841107);
      break;
    }
  }
  
  public void fetchVerifyImage(int paramInt1, QMVerify paramQMVerify, int paramInt2, SendVeifyCallBack paramSendVeifyCallBack, ImageDownloadListener paramImageDownloadListener)
  {
    this.imgUrl = paramQMVerify.getImageUrl();
    this.verifyKey = paramQMVerify.getVerifyKey();
    this.verifySession = paramQMVerify.getVerifySession();
    this.authImagesId = paramQMVerify.getAuthImagesId();
    this.retryVerifyCount = paramInt2;
    paramQMVerify = QMNetworkConfig.getCgiRequestHost(paramInt1) + this.imgUrl;
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(paramInt1);
    localDownloadInfo.setUrl(paramQMVerify);
    localDownloadInfo.setImageDownloadListener(new QMVerifyImageDialog.1(this, paramImageDownloadListener, paramSendVeifyCallBack));
    ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
  }
  
  public static abstract interface SendVeifyCallBack
  {
    public abstract void sendWithVerify(QMVerify paramQMVerify);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.verify.QMVerifyImageDialog
 * JD-Core Version:    0.7.0.1
 */