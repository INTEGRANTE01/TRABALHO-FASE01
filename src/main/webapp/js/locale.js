Edit in JSFiddle
JavaScript
HTML
CSS
Resources
Result
moment.locale('pt-BR');

$("pre.format")
    .append(" moment().format('MMMM D YYYY, h:mm:ss a')\t")
    .append(moment().format('MMMM D YYYY, h:mm:ss a'))

    .append("\n moment().format('dddd');\t\t\t")
    .append(moment().format('dddd'))

    .append("\n moment().format('MMM D YY');\t\t\t")
    .append(moment().format("MMM D YY"))

    .append("\n moment().format('YYYY [texto] YYYY');\t\t")
    .append(moment().format('YYYY [texto] YYYY'))

    .append("\n moment().format();\t\t\t\t")
    .append(moment().format());

$("pre.fromNow")
    .append(" moment('20111031', 'YYYYMMDD').fromNow(); \t")
    .append(moment('20111031', 'YYYYMMDD').fromNow())

    .append("\n moment('20120620', 'YYYYMMDD').fromNow();\t")
    .append(moment('20120620', 'YYYYMMDD').fromNow())

    .append("\n moment().startOf('day').fromNow();\t\t")
    .append(moment().startOf('day').fromNow())

    .append("\n moment().endOf('day').fromNow();\t\t")
    .append(moment().endOf('day').fromNow())

    .append("\n moment().startOf('hour').fromNow();\t\t")
    .append(moment().startOf('hour').fromNow());

$("pre.calendar")
    .append(" moment().subtract(10, 'days').calendar(); \t")
    .append(moment().subtract(10, 'days').calendar())

    .append("\n moment().subtract(6, 'days').calendar(); \t")
    .append(moment().subtract(6, 'days').calendar())

    .append("\n moment().subtract(3, 'days').calendar(); \t")
    .append(moment().subtract(3, 'days').calendar())

    .append("\n moment().subtract(1, 'days').calendar(); \t")
    .append(moment().subtract(1, 'days').calendar())

    .append("\n moment().calendar(); \t\t\t\t")
    .append(moment().calendar())

    .append("\n moment().add(1, 'days').calendar(); \t\t")
    .append(moment().add(1, 'days').calendar())

    .append("\n moment().add(3, 'days').calendar(); \t\t")
    .append(moment().add(3, 'days').calendar())

    .append("\n moment().add(10, 'days').calendar(); \t\t")
    .append(moment().add(10, 'days').calendar());

$("pre.locale")
    .append(" moment().format('L'); \t\t")
    .append(moment().format('L'))

    .append("\n moment().format('l'); \t\t")
    .append(moment().format('l'))

    .append("\n moment().format('LL'); \t")
    .append(moment().format('LL'))

    .append("\n moment().format('ll'); \t")
    .append(moment().format('ll'))

    .append("\n moment().format('LLL'); \t")
    .append(moment().format('LLL'))

    .append("\n moment().format('lll'); \t")
    .append(moment().format('lll'))

    .append("\n moment().format('LLLL'); \t")
    .append(moment().format('LLLL'))

    .append("\n moment().format('llll'); \t")
    .append(moment().format('llll'))
