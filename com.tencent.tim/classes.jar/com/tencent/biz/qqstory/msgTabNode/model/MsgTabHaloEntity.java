package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import puh;

public class MsgTabHaloEntity
  extends Entity
{
  public String headUrl;
  public String jumpUrl;
  public String localSuccessVideoList;
  public int noUpdate;
  public long nodeInfoTimeStamp;
  public int nodeType;
  public String nodeVid;
  public long recommendId;
  public long reqTimeStamp;
  public String title;
  @unique
  public long uid;
  @unique
  public String unionId;
  public String videoCover;
  public String videoInfoList;
  
  public static String getSelection()
  {
    return "uid=?";
  }
  
  public static String[] getSelectionArgs(puh parampuh)
  {
    return new String[] { String.valueOf(parampuh.uid) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("MsgTabHaloEntity{");
    localStringBuilder.append("nodeType=").append(this.nodeType);
    localStringBuilder.append(", uid=").append(this.uid);
    localStringBuilder.append(", unionId='").append(this.unionId).append('\'');
    localStringBuilder.append(", videoInfoList='").append(this.videoInfoList).append('\'');
    localStringBuilder.append(", reqTimeStamp=").append(this.reqTimeStamp);
    localStringBuilder.append(", nodeInfoTimeStamp=").append(this.nodeInfoTimeStamp);
    localStringBuilder.append(", localSuccessVideoList='").append(this.localSuccessVideoList).append('\'');
    localStringBuilder.append(", title='").append(this.title).append('\'');
    localStringBuilder.append(", headUrl='").append(this.headUrl).append('\'');
    localStringBuilder.append(", recommendId=").append(this.recommendId);
    localStringBuilder.append(", jumpUrl='").append(this.jumpUrl).append('\'');
    localStringBuilder.append(", nodeVid='").append(this.nodeVid).append('\'');
    localStringBuilder.append(", videoCover='").append(this.videoCover).append('\'');
    localStringBuilder.append(", noUpdate=").append(this.noUpdate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity
 * JD-Core Version:    0.7.0.1
 */