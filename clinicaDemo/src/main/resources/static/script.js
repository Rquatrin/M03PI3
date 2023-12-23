var circles = document.querySelectorAll('.circle');
                circles.forEach(function (circle) {
                    if (circle.id === 'aRealizado' && circle.innerText === 'true') {
                        circle.style.backgroundColor = 'green';
                    } else if (circle.id === 'aRealizado' && circle.innerText === 'false') {
                        circle.style.backgroundColor = 'red';
                    }
                });