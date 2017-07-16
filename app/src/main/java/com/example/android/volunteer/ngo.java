package com.example.android.volunteer;

/**
 * Created by shubham on 7/15/17.
 */

public class ngo {
    private String mTitle;
    private String mDescription;
    private String mImage;
    private String mNgoTitle;
    private int mPeopleRequired;
    private String[] mSkills;
    private int[] mRequirement;
    private long mEventDate;
    private long mCreateDate;
    public int id;

    public ngo(String title,String description,String image,String ngoTitle,int peopleRequired,String[] skills
                ,int[] requirement,long eventDate,long createDate,int inputid)
    {
        mTitle=title;
        mDescription=description;
        mImage=image;
        mNgoTitle=ngoTitle;
        mPeopleRequired=peopleRequired;
        mSkills=skills;
        mRequirement=requirement;
        mEventDate=eventDate;
        mCreateDate=createDate;
        id=inputid;
    }

    public String getTitle()
    {
        return mTitle;
    }
    public String getDescription()
    {
        return mDescription;
    }
    public String getImage()
    {
        return mImage;
    }
    public String getNgoTitle()
    {
        return mNgoTitle;
    }
    public int getPeopleRequired()
    {
        return mPeopleRequired;
    }

    public long getEventDate()
    {
        return mEventDate;
    }
    public long getCreateDate()
    {
        return mCreateDate;
    }
    public String[] getSkills()
    {
        return mSkills;
    }
    public int[] getRequirement()
    {
        return mRequirement;
    }
}
