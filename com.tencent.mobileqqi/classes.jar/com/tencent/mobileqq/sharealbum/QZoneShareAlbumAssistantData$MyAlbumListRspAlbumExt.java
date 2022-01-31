package com.tencent.mobileqq.sharealbum;

public class QZoneShareAlbumAssistantData$MyAlbumListRspAlbumExt
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  public QZoneShareAlbumAssistantData$MyAlbumListRspAlbumExt(QZoneShareAlbumAssistantData paramQZoneShareAlbumAssistantData)
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData)
  {
    paramQZoneShareAlbumAssistantItemData.albumID = this.jdField_a_of_type_JavaLangString;
    paramQZoneShareAlbumAssistantItemData.unreadCount = this.jdField_a_of_type_Long;
    paramQZoneShareAlbumAssistantItemData.desc = this.jdField_b_of_type_JavaLangString;
    paramQZoneShareAlbumAssistantItemData.lastmsgtime = this.jdField_b_of_type_Long;
    paramQZoneShareAlbumAssistantItemData.isUnread = this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantData.MyAlbumListRspAlbumExt
 * JD-Core Version:    0.7.0.1
 */