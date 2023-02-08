    package dev.kjellin.excersice2pia11

    import android.os.Bundle
    import android.util.Log
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.commit
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView

    class StartFragment : Fragment() {

        lateinit var listadapter : ListAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_start, container, false)

            return view
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val data = arrayOf("Rad1","Rad2","Rad3","Rad4","Rad5")

            listadapter = ListAdapter(data){
                Log.i("pia11debug", "KLICK PÅ RAD")
                var godetail = DetailFragment()
                requireActivity().supportFragmentManager.commit {
                    add(R.id.fragmentContainerView, godetail)
                    addToBackStack(null)
                }
            }
            val recycview = view.findViewById<RecyclerView>(R.id.itemRecycView)
            recycview.adapter = listadapter
            recycview.layoutManager = LinearLayoutManager(requireContext())
        }
    }
