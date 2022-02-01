package com.tencent.qqmail.activity.media;

import java.util.Comparator;

final class MediaData$1
  implements Comparator<MediaItemInfo>
{
  public int compare(MediaItemInfo paramMediaItemInfo1, MediaItemInfo paramMediaItemInfo2)
  {
    if ((paramMediaItemInfo1 == null) || (paramMediaItemInfo2 == null)) {
      if (paramMediaItemInfo1 != null) {}
    }
    while (paramMediaItemInfo2.getModifyDate() > paramMediaItemInfo1.getModifyDate())
    {
      return 1;
      return -1;
    }
    if (paramMediaItemInfo1.getModifyDate() == paramMediaItemInfo2.getModifyDate()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.media.MediaData.1
 * JD-Core Version:    0.7.0.1
 */