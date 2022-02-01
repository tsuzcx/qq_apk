package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.utilities.animation.AnimUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import java.util.HashMap;
import java.util.List;

public class AttachGridAdapter
  extends ArrayAdapter<AttachInfo>
{
  public static HashMap<String, Integer> attachImage = null;
  private SparseArray<View> cachedViews;
  private int resId;
  
  public AttachGridAdapter(Context paramContext, int paramInt, List<AttachInfo> paramList)
  {
    super(paramContext, paramInt, paramList);
    this.resId = paramInt;
    this.cachedViews = new SparseArray();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (View)this.cachedViews.get(paramInt);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(getContext()).inflate(this.resId, null);
      this.cachedViews.put(paramInt, paramView);
    }
    for (int i = 1;; i = 0)
    {
      QMComposeAttachItem localQMComposeAttachItem = (QMComposeAttachItem)paramView;
      if (i != 0) {
        localQMComposeAttachItem.loadViews();
      }
      AttachInfo localAttachInfo = (AttachInfo)getItem(paramInt);
      boolean bool = localAttachInfo.isLoadError();
      localQMComposeAttachItem.setAttachName(localAttachInfo.getAttachName());
      label115:
      Object localObject1;
      if (bool)
      {
        localQMComposeAttachItem.setAttachNameRed();
        if (!localAttachInfo.isNewSameName()) {
          break label455;
        }
        paramView.findViewById(2131365139).setVisibility(0);
        if (!localAttachInfo.isBigAttach()) {
          break label469;
        }
        Object localObject2 = getContext().getString(2131693301);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(localAttachInfo.getAttachSize())) {
          localObject1 = (String)localObject2 + " " + localAttachInfo.getAttachSize();
        }
        localQMComposeAttachItem.setAttachSize((String)localObject1);
        if (((localAttachInfo.getAttach() instanceof MailBigAttach)) && (((MailBigAttach)localAttachInfo.getAttach()).getExpireTimeMilli() == -1L)) {
          localQMComposeAttachItem.setAttachSize(getContext().getString(2131690873) + " " + localAttachInfo.getAttachSize());
        }
        label255:
        localObject1 = QMAttachUtils.getThumbnail(localAttachInfo);
        if (!"VIDEO".equals(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(localAttachInfo.getAttachName())))) {
          break label497;
        }
        paramView.findViewById(2131365141).setVisibility(0);
        label291:
        if (localObject1 == null) {
          break label511;
        }
        localQMComposeAttachItem.setAttachImage((Bitmap)localObject1);
        if (localAttachInfo.getThumbnailData() == null) {
          localAttachInfo.setThumbnailData(localObject1);
        }
        label318:
        if ((!localAttachInfo.isProcessed()) && (!localAttachInfo.isLoadError())) {
          break label536;
        }
        localQMComposeAttachItem.hideLoading();
        label339:
        if ((i == 0) || (!localAttachInfo.isNewAdded())) {
          break label553;
        }
        localAttachInfo.setNewAdded(false);
        localObject1 = AnimationUtils.loadAnimation(getContext(), 2130772401);
        ((Animation)localObject1).setDuration(500L);
        localObject2 = AnimUtil.getOrientationReviseAnimation(getContext(), ((AttachInfo)getItem(paramInt)).getOrientationAngel());
        if (localObject2 == null) {
          break label544;
        }
        ((Animation)localObject2).setFillAfter(true);
        ((Animation)localObject2).setDuration(0L);
        paramView.findViewById(2131363033).startAnimation((Animation)localObject2);
        paramView.setAnimation((Animation)localObject1);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localQMComposeAttachItem.setAttachNameDefaultColor();
        break;
        label455:
        paramView.findViewById(2131365139).setVisibility(8);
        break label115;
        label469:
        if (bool)
        {
          localQMComposeAttachItem.setAttachSize("下载失败");
          break label255;
        }
        localQMComposeAttachItem.setAttachSize(localAttachInfo.getAttachSize());
        break label255;
        label497:
        paramView.findViewById(2131365141).setVisibility(8);
        break label291;
        label511:
        localQMComposeAttachItem.setAttachImage(ImageResourceUtil.getImageResource(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(localAttachInfo.getAttachName())), ImageResourceUtil.IMAGE_SIZE_76));
        break label318;
        label536:
        localQMComposeAttachItem.showLoading();
        break label339;
        label544:
        paramView.setAnimation((Animation)localObject1);
        continue;
        label553:
        i = ((AttachInfo)getItem(paramInt)).getOrientationAngel();
        localObject1 = AnimUtil.getOrientationReviseAnimation(getContext(), i);
        if (localObject1 != null)
        {
          ((Animation)localObject1).setDuration(0L);
          ((Animation)localObject1).setFillAfter(true);
          paramView.findViewById(2131363033).startAnimation((Animation)localObject1);
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void recycle()
  {
    this.cachedViews = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.AttachGridAdapter
 * JD-Core Version:    0.7.0.1
 */