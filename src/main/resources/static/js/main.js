$(document).ready(function () {
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('href');

        $.get(href, function (user) {
            $('.editForm #id').val(user.id);
            $('.editForm #firstName').val(user.firstName);
            $('.editForm #lastName').val(user.lastName);
            $('.editForm #age').val(user.age);
            $('.editForm #email').val(user.email);

        })

        $('.editForm #exampleModal').modal();
    });
});

$(document).ready(function () {
    $('.table .eBtnDelete').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('href');

        $.get(href, function (user) {
            $('.deleteForm #id').val(user.id);
            $('.deleteForm #firstName').val(user.firstName);
            $('.deleteForm #lastName').val(user.lastName);
            $('.deleteForm #age').val(user.age);
            $('.deleteForm #email').val(user.email);

            $('#roleSet').prop('disabled', true);
            $('#roleSet option').remove();

            $.each(user.roleSet, function (index, value) {
                $('#roleSet').append('<option value="' + index + '">' + value.name + '</option>');
            })
        })
        $('.deleteForm #exampleModalDelete').modal();
    });
});