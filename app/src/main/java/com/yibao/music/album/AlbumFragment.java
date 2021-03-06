package com.yibao.music.album;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yibao.music.R;
import com.yibao.music.base.BaseFragment;
import com.yibao.music.util.ColorUtil;
import com.yibao.music.util.Constants;
import com.yibao.music.util.LogUtil;
import com.yibao.music.view.music.MusicView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @项目名： ArtisanMusic
 * @包名： com.yibao.music.album
 * @文件名: AlbumFragment
 * @author: Stran
 * @Email: www.strangermy@outlook.com / www.stranger98@gmail.com
 * @创建时间: 2018/2/8 20:01
 * @描述： {TODO}
 */

public class AlbumFragment extends BaseFragment {
    @BindView(R.id.iv_album_category_random_paly)
    ImageView mIvAlbumCategoryRandomPaly;
    @BindView(R.id.iv_album_category_list)
    ImageView mIvAlbumCategoryList;
    @BindView(R.id.tv_album_category_list)
    TextView mTvAlbumCategoryList;
    @BindView(R.id.album_category_list_ll)
    LinearLayout mAlbumCategoryListLl;
    @BindView(R.id.iv_album_category_tile)
    ImageView mIvAlbumCategoryTile;
    @BindView(R.id.tv_album_category_tile)
    TextView mTvAlbumCategoryTile;
    @BindView(R.id.album_category_tile_ll)
    LinearLayout mAlbumCategoryTileLl;
    @BindView(R.id.iv_album_category_paly)
    ImageView mIvAlbumCategoryPaly;
    @BindView(R.id.album_music_view)
    MusicView mAlbumMusicView;


    private Unbinder unbinder;
    private AlbumAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.album_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData(Constants.NUMBER_ZOER, true, Constants.NUMBER_THRRE);
        return view;
    }




    /**
     * 加载列表
     *
     * @param adapterShowType       普通视图显示  和 GridView视图显示  ( 3 列 )
     * @param isShowSlideBar        是否显示SlideBar
     * @param adapterAndManagerType RecyclerView的Manager ，3 == LinearLayoutManager
     *                              4 == GridLayoutManager
     */
    private void initData(int adapterShowType, boolean isShowSlideBar, int adapterAndManagerType) {
        mAdapter = new AlbumAdapter(mActivity, mAlbumList, adapterShowType);
        mAlbumMusicView.setAdapter(mActivity, adapterAndManagerType, isShowSlideBar, mAdapter);
    }


    @OnClick({R.id.iv_album_category_random_paly,
            R.id.album_category_list_ll, R.id.album_category_tile_ll, R.id.iv_album_category_paly})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_album_category_random_paly:

                LogUtil.d("=================randomplay");
                break;
            case R.id.iv_album_category_paly:
                break;
            case R.id.album_category_list_ll:
                switchCategory(Constants.NUMBER_ZOER);
                initData(Constants.NUMBER_ZOER, true, Constants.NUMBER_THRRE);
                break;
            case R.id.album_category_tile_ll:
                switchCategory(Constants.NUMBER_ONE);
                initData(Constants.NUMBER_ONE, false, Constants.NUMBER_FOUR);
                break;
            default:
                break;
        }
    }

    private void switchCategory(int showType) {
        if (showType == Constants.NUMBER_ZOER) {

            mAlbumCategoryListLl.setBackgroundResource(R.drawable.btn_category_songname_down_selector);
            mIvAlbumCategoryList.setImageResource(R.drawable.album_category_list_down_selector);
            mTvAlbumCategoryList.setTextColor(ColorUtil.wihtle);


            mAlbumCategoryTileLl.setBackgroundResource(R.drawable.btn_category_views_selector);

            mIvAlbumCategoryTile.setImageResource(R.drawable.album_category_tile_selector);

            mTvAlbumCategoryTile.setTextColor(ColorUtil.textName);

        } else if (showType == Constants.NUMBER_ONE) {

            mAlbumCategoryTileLl.setBackgroundResource(R.drawable.btn_category_views_down_selector);
            mIvAlbumCategoryTile.setImageResource(R.drawable.album_category_tile_down_selector);
            mTvAlbumCategoryTile.setTextColor(ColorUtil.wihtle);

            mAlbumCategoryListLl.setBackgroundResource(R.drawable.btn_category_songname_selector);
            mIvAlbumCategoryList.setImageResource(R.drawable.album_category_list_selector);
            mTvAlbumCategoryList.setTextColor(ColorUtil.textName);


        }


    }

    public static AlbumFragment newInstance() {
        return new AlbumFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

}
