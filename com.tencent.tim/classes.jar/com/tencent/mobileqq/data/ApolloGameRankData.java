package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.qphone.base.util.QLog;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="mGameId,mFriendUin")
public class ApolloGameRankData
  extends Entity
{
  private static final String TAG = "ApolloGameRankData";
  public String mFriendUin;
  public int mGameId;
  public int mRank;
  public long mValidTime;
  
  public boolean equals(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof ApolloGameRankData)) && (((ApolloGameRankData)paramObject).mGameId == this.mGameId) && (this.mFriendUin.equals(((ApolloGameRankData)paramObject).mFriendUin));
  }
  
  public boolean isInvalid()
  {
    if (QLog.isColorLevel()) {
      if (this.mValidTime <= System.currentTimeMillis()) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ApolloGameRankData", 2, new Object[] { Boolean.valueOf(bool) });
      if (this.mValidTime <= System.currentTimeMillis()) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    return this.mFriendUin + " " + this.mGameId + " " + this.mRank;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloGameRankData
 * JD-Core Version:    0.7.0.1
 */