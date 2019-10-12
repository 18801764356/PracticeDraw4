package demo.wj.practicedraw4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var pageModels: MutableList<PageModel> = arrayListOf(
        PageModel(R.layout.sample_clip_rect, R.string.title_clip_rect, R.layout.practice_clip_rect),
        PageModel(R.layout.sample_clip_path, R.string.title_clip_path, R.layout.practice_clip_path),
        PageModel(R.layout.sample_translate, R.string.title_translate, R.layout.practice_translate),
        PageModel(R.layout.sample_scale, R.string.title_scale, R.layout.practice_scale),
        PageModel(R.layout.sample_rotate, R.string.title_rotate, R.layout.practice_rotate),
        PageModel(R.layout.sample_skew, R.string.title_skew, R.layout.practice_skew),
        PageModel(R.layout.sample_matrix_translate, R.string.title_matrix_translate, R.layout.practice_matrix_translate),
        PageModel(R.layout.sample_matrix_scale, R.string.title_matrix_scale, R.layout.practice_matrix_scale),
        PageModel(R.layout.sample_matrix_rotate, R.string.title_matrix_rotate, R.layout.practice_matrix_rotate),
        PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_skew, R.layout.practice_matrix_skew),
        PageModel(R.layout.sample_matrix_skew, R.string.title_matrix_poly_to_poly, R.layout.practice_matrix_poly_to_poly),
        PageModel(R.layout.sample_camera_rotate, R.string.title_camera_rotate, R.layout.practice_camera_rotate),
        PageModel(R.layout.sample_camera_rotate_fixed, R.string.title_camera_rotate_fixed, R.layout.practice_measure_text),
        PageModel(R.layout.sample_camera_rotate_hitting_face, R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face),
        PageModel(R.layout.sample_flipboard, R.string.title_flipboard, R.layout.practice_flipboard)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager.setAdapter(object : FragmentPagerAdapter(supportFragmentManager) {

            override fun getItem(position: Int): Fragment {
                val pageModel = pageModels.get(position)
                return PageFragment.newInstance(
                    pageModel.sampleLayoutRes,
                    pageModel.practiceLayoutRes
                )
            }

            override fun getCount(): Int {
                return pageModels.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return getString(pageModels[position].titleRea)
            }
        })
        tablayout.setupWithViewPager(viewpager)
    }

}
