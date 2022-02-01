package com.tencent.mobileqq.search.util;

import aclj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.qphone.base.util.QLog;

public final class SearchUtils$1
  implements Runnable
{
  public SearchUtils$1(String paramString1, int paramInt, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtils", 2, "saveSearchHistory, displayName:" + this.val$name);
    }
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = this.val$type;
    localSearchHistory.uin = this.val$uin;
    localSearchHistory.troopUin = this.Uf;
    localSearchHistory.displayName = this.val$name;
    aclj localaclj = (aclj)this.val$app.getManager(55);
    if (localaclj == null) {
      return;
    }
    localaclj.a(localSearchHistory);
    com.tencent.mobileqq.search.activity.UniteSearchActivity.cDl = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchUtils.1
 * JD-Core Version:    0.7.0.1
 */