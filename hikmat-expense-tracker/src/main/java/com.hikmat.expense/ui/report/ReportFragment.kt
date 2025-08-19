class ReportFragment : Fragment() {

    private lateinit var reportViewModel: ReportViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reportViewModel = ViewModelProvider(this).get(ReportViewModel::class.java)

        // Observe the weekly expenditure data
        reportViewModel.weeklyExpenditure.observe(viewLifecycleOwner, Observer { expenditureList ->
            // Update UI with the expenditure data
            // For example, display it in a RecyclerView or TextView
        })
    }
}