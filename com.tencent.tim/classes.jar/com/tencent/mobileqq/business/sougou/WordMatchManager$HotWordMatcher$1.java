package com.tencent.mobileqq.business.sougou;

import java.lang.ref.WeakReference;

class WordMatchManager$HotWordMatcher$1
  implements Runnable
{
  WordMatchManager$HotWordMatcher$1(WordMatchManager.HotWordMatcher paramHotWordMatcher, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.gD != null))
    {
      WordMatchManager.c localc = (WordMatchManager.c)this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.gD.get();
      if (localc != null) {
        localc.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.requestCode, this.jdField_a_of_type_ArrayOfComTencentMobileqqBusinessSougouWordMatchManager$HotWordItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.dispatchNextTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher.1
 * JD-Core Version:    0.7.0.1
 */