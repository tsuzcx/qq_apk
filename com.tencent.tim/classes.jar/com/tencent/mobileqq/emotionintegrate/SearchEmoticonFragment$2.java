package com.tencent.mobileqq.emotionintegrate;

import android.text.TextUtils;
import aoiz;
import aoop;
import aqhq;
import com.tencent.mobileqq.data.MessageForPic;
import java.net.URL;

class SearchEmoticonFragment$2
  implements Runnable
{
  SearchEmoticonFragment$2(SearchEmoticonFragment paramSearchEmoticonFragment, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    Object localObject = aoop.a(this.h, 1, null);
    if ((localObject != null) && (aoiz.getFile(((URL)localObject).toString()) == null))
    {
      localObject = aoiz.getFilePath(((URL)localObject).toString());
      if ((!TextUtils.isEmpty(this.h.path)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        aqhq.copyFile(this.h.path, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment.2
 * JD-Core Version:    0.7.0.1
 */